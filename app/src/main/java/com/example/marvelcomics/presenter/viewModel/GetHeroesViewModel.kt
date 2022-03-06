package com.example.marvelcomics.presenter.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.domain.useCases.GetHeroesUseCase
import com.example.marvelcomics.presenter.model.HeroesUiModel
import com.example.marvelcomics.presenter.model.toHereosUiModel
import com.example.marvelcomics.utils.OutPut
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