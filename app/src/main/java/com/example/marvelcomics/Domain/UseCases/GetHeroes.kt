package com.example.marvelcomics.Domain.UseCases


import android.util.Log
import com.example.marvelcomics.Data.MarvelApiRepository
import com.example.marvelcomics.Domain.Models.Heroes

class GetHeroes(val marvelApiImpl: MarvelApiRepository) : GetHeroesUseCase {

    override suspend fun invoke(): Heroes {
        return try {
            marvelApiImpl.getHeroes()
        } catch (ex : Exception){
            throw Exception()
        }
    }
}

interface GetHeroesUseCase {
    suspend operator fun invoke() : Heroes
}