package com.example.marvelcomics.Data.Model

import com.google.gson.annotations.SerializedName

data class Urls(
    @SerializedName("type") var type : String,
    @SerializedName("url") var url : String
)
