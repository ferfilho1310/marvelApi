package com.example.marvelcomics.domain.useCases

import com.example.marvelcomics.data.MarvelApiRepository
import com.example.marvelcomics.domain.models.Heroes



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