package com.example.cats_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Order {
    @SerialName("ASC") ASC,
    @SerialName("DESC") DESC,
    @SerialName("RANDOM") RANDOM,
}