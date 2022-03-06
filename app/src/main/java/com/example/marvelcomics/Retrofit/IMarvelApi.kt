package com.example.marvelcomics.Retrofit

import android.icu.util.Output
import com.example.marvelcomics.Data.Model.HeroesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMarvelApi {

    @GET("{key}/{id}/image")
    suspend fun getListHeroes(
        @Path("key") key: String,
        @Path("id") id : String
    ): Response<HeroesResponse>

}