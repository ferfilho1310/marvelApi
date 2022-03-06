package com.example.marvelcomics.retrofit

import com.example.marvelcomics.data.model.HeroesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IMarvelApi {

    @GET("{key}/{id}/image")
    suspend fun getListHeroes(
        @Path("key") key: String,
        @Path("id") id : String
    ): Response<HeroesResponse>

}