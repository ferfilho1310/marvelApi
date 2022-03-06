package com.example.marvelcomics.data

import com.example.marvelcomics.data.model.toHeroesResponse
import com.example.marvelcomics.domain.models.Heroes
import com.example.marvelcomics.retrofit.*
import com.example.marvelcomics.utils.OutPut
import com.example.marvelcomics.utils.parseResponse

class MarvelApiImpl(val IMarvelApi: IMarvelApi) : MarvelApiRepository {

    override suspend fun getHeroes(id : Int): Heroes {
        val response = IMarvelApi.getListHeroes(key,id.toString()).parseResponse()
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
    suspend fun getHeroes(id: Int): Heroes
}