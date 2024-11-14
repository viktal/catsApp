package com.example.cats_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedDTO (
    @SerialName("id") val id: String,
    @SerialName("name") val name: String? = null,
    @SerialName("temperament") val temperament: String? = null,
    @SerialName("origin") val origin: String? = null,
    @SerialName("description") val description: String? = null,
)