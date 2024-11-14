package com.example.data.model

data class Cat(
    val id: String,
    val url: String?,
    val width: Int?,
    val height: Int?,
    val breed: List<Breed>?,
)