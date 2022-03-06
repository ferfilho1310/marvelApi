package com.example.marvelcomics.utils

import retrofit2.Response

sealed class OutPut<out Response> {
    data class Success<Response> (val value : Response): OutPut<Response>()
    data class Failure(val error: Throwable): OutPut<Nothing>()
}

fun <R : Any> Response<R>.parseResponse(): OutPut<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return OutPut.Success(body)
        }
    } else {
        return OutPut.Failure(Exception())

    }
    return OutPut.Failure(Exception())
}
