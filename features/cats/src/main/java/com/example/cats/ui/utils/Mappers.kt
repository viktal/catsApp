package com.example.cats.ui.utils

import com.example.cats.ui.model.CatUI
import com.example.data.model.Cat

internal fun Cat.toCatUI(): CatUI {
    return CatUI(
        id = this.id,
        imageUrl = this.url,
        breed = this.breed?.map { it.name }?.joinToString(),
        country = this.breed?.map { it.origin }?.joinToString(),
        description = this.breed?.map { it.description }?.joinToString(),
        temperament = this.breed?.map { it.temperament }?.joinToString()
    )
}
