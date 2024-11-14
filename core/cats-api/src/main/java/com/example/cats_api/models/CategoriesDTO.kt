package com.example.cats_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDTO (
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
)
