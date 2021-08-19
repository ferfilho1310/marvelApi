package com.example.marvelcomics.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private var retrofit: Retrofit? = null

const val hash = "5bff35541d3a59dbd7273c3ed23f1f8e"
const val publicKey = "8471dc482b6dd1140e8bb074b940b8af"
const val timesTampApiUrl = "1629245895"

var URL = "https://gateway.marvel.com:443/v1/public/"
var URL_1 = "https://covid19-brazil-api.now.sh/api/report/v1/"

fun getRetrofit(): Retrofit? {
    retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit
}

fun provideApiMarvel(retrofit: Retrofit) = retrofit.create(IMarvelApi::class.java)
