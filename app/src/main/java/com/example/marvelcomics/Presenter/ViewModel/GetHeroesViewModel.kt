package com.example.marvelcomics.Presenter.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.Domain.UseCases.GetHeroesUseCase
import com.example.marvelcomics.Presenter.Model.HeroesUiModel
import com.example.marvelcomics.Presenter.Model.toHereosUiModel
import com.example.marvelcomics.Utils.OutPut
import kotlinx.coroutines.launch

class GetHeroesViewModel(val getHeroes: GetHeroesUseCase) : ViewModel() {

    val getHeroesLiveData: MutableLiveData<OutPut<HeroesUiModel>> = MutableLiveData()

    fun getHeroesImpl(id: Int) {
        viewModelScope.launch {
            runCatching {
                getHeroes.invoke(id)
            }.onSuccess {
                getHeroesLiveData.value = OutPut.Success(it.toHereosUiModel())
            }.onFailure {
                OutPut.Failure(it)
            }
        }
    }
}