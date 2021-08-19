package com.example.marvelcomics.di

import com.example.marvelcomics.Data.MarvelApiImpl
import com.example.marvelcomics.Data.MarvelApiRepository
import com.example.marvelcomics.Domain.UseCases.GetHeroes
import com.example.marvelcomics.Domain.UseCases.GetHeroesUseCase
import com.example.marvelcomics.Presenter.Activity.MainActivity
import com.example.marvelcomics.Presenter.ViewModel.GetHeroesViewModel
import com.example.marvelcomics.Retrofit.IMarvelApi
import com.example.marvelcomics.Retrofit.getRetrofit
import com.example.marvelcomics.Retrofit.provideApiMarvel
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