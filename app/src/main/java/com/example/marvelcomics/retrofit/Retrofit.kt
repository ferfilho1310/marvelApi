package com.example.marvelcomics.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private var retrofit: Retrofit? = null

const val key = "5301688166590027"

var URL = "https://superheroapi.com/api/"

fun getRetrofit(): Retrofit? {
    retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit
}

fun provideApiMarvel(retrofit: Retrofit) = retrofit.create(IMarvelApi::class.java)
