package com.example.marvelcomics.Utils

import retrofit2.Response
import java.net.HttpURLConnection

sealed class OutPut<out Response> {
    data class Success<Response> (val value : Response): OutPut<Response>()
    data class Failure(val statusCode: Int): OutPut<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): OutPut<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return OutPut.Success(body)
        }
    } else {
        return OutPut.Failure(code())

    }
    return OutPut.Failure(HttpURLConnection.HTTP_INTERNAL_ERROR)
}
