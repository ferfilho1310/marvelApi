package com.example.marvelcomics.Data.Model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") var id : String,
    @SerializedName("name") var name : String,
    @SerializedName("description") var description : String,
    @SerializedName("modified") var modified : String,
    @SerializedName("resourceURI") var resourceURI : String,
    @SerializedName("urls") var urls : List<Urls>,
    @SerializedName("thumbnail") var thumbnail : Thumbnail,
    @SerializedName("comics") var comics : Comics,
    @SerializedName("stories") var stories : Stories,
    @SerializedName("events") var events : Events,
    @SerializedName("series") var series : Series
)
