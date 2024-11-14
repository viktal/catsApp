package com.example.cats_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseDTO(
    @SerialName("id") val id: String,
    @SerialName("url") val url: String? = null,
    @SerialName("width") val width: Int? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("breeds") val breeds: List<BreedDTO>? = null,
    @SerialName("categories") val categories: List<CategoriesDTO>? = null,
)