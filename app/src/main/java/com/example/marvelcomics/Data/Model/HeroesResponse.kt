package com.example.marvelcomics.Data.Model

import com.example.marvelcomics.Data.Model.Data
import com.example.marvelcomics.Domain.Models.Heroes
import com.google.gson.annotations.SerializedName

data class HeroesResponse(

    @SerializedName("code") var code : String,
    @SerializedName("status") var status : String,
    @SerializedName("copyright") var copyright : String,
    @SerializedName("attributionText") var attributionText : String,
    @SerializedName("attributionHTML") var attributionHTML : String,
    @SerializedName("data") var data : Data,
    @SerializedName("etag") var etag : String
)

fun HeroesResponse.toHeroesResponse() = Heroes(
    code = this.code,
    status = this.status,
    copyright = this.copyright,
    attributionText = this.attributionText,
    attributionHTML = this.attributionHTML,
    data = this.data,
    etag = this.etag

)


