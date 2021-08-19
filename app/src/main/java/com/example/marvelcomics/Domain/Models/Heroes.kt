package com.example.marvelcomics.Domain.Models

import com.example.marvelcomics.Data.Model.Data

data class Heroes(
    var code: String,
    var status: String,
    var copyright: String,
    var attributionText: String,
    var attributionHTML: String,
    var data: Data,
    var etag: String
)

