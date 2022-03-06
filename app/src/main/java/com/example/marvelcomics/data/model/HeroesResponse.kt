package com.example.marvelcomics.data.model

import com.example.marvelcomics.domain.models.Heroes
import com.google.gson.annotations.SerializedName

data class HeroesResponse(

    @SerializedName("response") var response : String,
    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String,
    @SerializedName("url") var url : String
)

fun HeroesResponse.toHeroesResponse() = Heroes(
    response = this.response,
    id = this.id,
    name = this.name,
    url = this.url
)


