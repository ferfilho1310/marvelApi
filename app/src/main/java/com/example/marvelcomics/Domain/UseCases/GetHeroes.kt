package com.example.marvelcomics.Domain.UseCases

import com.example.marvelcomics.Data.MarvelApiRepository
import com.example.marvelcomics.Domain.Models.Heroes



class GetHeroes(val marvelApiImpl: MarvelApiRepository) : GetHeroesUseCase {

    override suspend fun invoke(id : Int): Heroes {
        return try {
            marvelApiImpl.getHeroes(id)
        } catch (ex : Exception){
            throw Exception()
        }
    }

}

interface GetHeroesUseCase {
    suspend operator fun invoke(id : Int) : Heroes
}