package com.example.marvelcomics.Presenter.Model

import com.example.marvelcomics.Domain.Models.Heroes

class HeroesUiModel(
    var id : String,
    var name : String,
    var url : String
)

fun Heroes.toHereosUiModel() = HeroesUiModel(
    id = this.id,
    name = this.name,
    url = this.url
)
