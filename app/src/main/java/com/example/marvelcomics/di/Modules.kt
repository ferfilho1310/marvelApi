package com.example.marvelcomics.di

import com.example.marvelcomics.data.MarvelApiImpl
import com.example.marvelcomics.data.MarvelApiRepository
import com.example.marvelcomics.domain.useCases.GetHeroes
import com.example.marvelcomics.domain.useCases.GetHeroesUseCase
import com.example.marvelcomics.presenter.activity.MainActivity
import com.example.marvelcomics.presenter.viewModel.GetHeroesViewModel
import com.example.marvelcomics.retrofit.IMarvelApi
import com.example.marvelcomics.retrofit.getRetrofit
import com.example.marvelcomics.retrofit.provideApiMarvel
import org.koin.dsl.module

object Modules {

    val viewModel = module {
        single { GetHeroesViewModel(get() as GetHeroesUseCase)}
    }

    val activityModule = module {
        single { MainActivity() }
    }

    val useCaseModule = module {
        factory<GetHeroesUseCase> { GetHeroes(get()) }
    }

    val netWorkModule = module(override = true) {
        factory { getRetrofit() }
        single<IMarvelApi> { provideApiMarvel(get()) }
    }

    val implModule = module {
        factory<MarvelApiRepository> { MarvelApiImpl(get()) }
    }

}