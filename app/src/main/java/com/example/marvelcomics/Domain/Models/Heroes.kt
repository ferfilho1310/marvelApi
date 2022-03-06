package com.example.marvelcomics.Domain.Models

import com.google.gson.annotations.SerializedName

data class Heroes(
    var response : String,
    var id : String,
    var name : String,
    var url : String
)

