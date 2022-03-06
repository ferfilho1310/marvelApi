package com.example.marvelcomics.presenter.model

import com.example.marvelcomics.domain.models.Heroes

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
