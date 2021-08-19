package com.example.marvelcomics.Data.Model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("offset") var offset : String,
    @SerializedName("limit") var limit : String,
    @SerializedName("total") var total : String,
    @SerializedName("count") var count : String,
    @SerializedName("results") var results : List<Results>
)
