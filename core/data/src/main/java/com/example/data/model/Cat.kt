package com.example.data.model

data class Cat(
    val id: String,
    val imageUrl: String?,
    val breed: String?,
    val country: String?,
    val description: String?,
    val temperament: String?,
    val isFavorite: Boolean? = false,
)