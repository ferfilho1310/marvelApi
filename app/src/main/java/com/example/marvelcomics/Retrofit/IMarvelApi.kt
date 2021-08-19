package com.example.marvelcomics.Retrofit

import com.example.marvelcomics.Data.Model.HeroesResponse
import com.example.marvelcomics.Utils.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import java.sql.Timestamp

interface IMarvelApi {

    @GET("stories")
    suspend fun getListHeroes(
        @Query("ts") timestamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
    ): Response<HeroesResponse>

}