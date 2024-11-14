package com.example.cats.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class CatUI (
    val id: String,
    val imageUrl: String?,
    val breed: String?,
    val country: String?,
    val description: String?,
    val temperament: String?,
)
