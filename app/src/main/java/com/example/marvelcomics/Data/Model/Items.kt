package com.example.marvelcomics.Data.Model

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("resourceURI") var resourceURI : String,
    @SerializedName("name") var name : String
)
