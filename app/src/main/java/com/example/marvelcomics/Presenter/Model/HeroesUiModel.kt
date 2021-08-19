package com.example.marvelcomics.Presenter.Model

import com.example.marvelcomics.Data.Model.Data
import com.example.marvelcomics.Domain.Models.Heroes

class HeroesUiModel(
    var data: Data
)

fun Heroes.toHereosUiModel() = HeroesUiModel(
    data = this.data
)