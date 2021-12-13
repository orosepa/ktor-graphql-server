package com.example.models

import java.util.*

data class Book(
    val id: String,
    var title: String,
    var genre: String,
    var author: String
)

data class InputBook(
    var title: String,
    var genre: String,
    var author: String
)