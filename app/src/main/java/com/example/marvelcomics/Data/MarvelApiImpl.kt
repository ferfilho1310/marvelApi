package com.example.marvelcomics.Data

import com.example.marvelcomics.Data.Model.toHeroesResponse
import com.example.marvelcomics.Domain.Models.Heroes
import com.example.marvelcomics.Retrofit.*
import com.example.marvelcomics.Utils.OutPut
import com.example.marvelcomics.Utils.parseResponse

class MarvelApiImpl(val IMarvelApi: IMarvelApi) : MarvelApiRepository {

    override suspend fun getHeroes(): Heroes {
        val response = IMarvelApi.getListHeroes(timesTampApiUrl, publicKey, hash).parseResponse()
        return when (response) {
            is OutPut.Failure -> throw Exception()
            is OutPut.Success -> {
                val heroes = response.value

                heroes.toHeroesResponse()
            }
        }
    }
}

interface MarvelApiRepository {
    suspend fun getHeroes(): Heroes
}