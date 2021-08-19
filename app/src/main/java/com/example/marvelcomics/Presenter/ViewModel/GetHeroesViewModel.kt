package com.example.marvelcomics.Presenter.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.Domain.Models.Heroes
import com.example.marvelcomics.Domain.UseCases.GetHeroes
import com.example.marvelcomics.Domain.UseCases.GetHeroesUseCase
import com.example.marvelcomics.Presenter.Model.HeroesUiModel
import com.example.marvelcomics.Presenter.Model.toHereosUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GetHeroesViewModel(val getHeroes: GetHeroesUseCase) : ViewModel() {

    val getHeroesLiveData: MutableLiveData<HeroesUiModel> = MutableLiveData()

    fun getHeroesImpl() {
        viewModelScope.launch {
            val heroes = getHeroes.invoke()

            getHeroesLiveData.value = heroes.toHereosUiModel()

        }
    }
}