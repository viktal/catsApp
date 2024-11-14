package com.example.cats.ui.utils

import com.example.cats.ui.model.CatUI
import com.example.data.model.Cat

internal fun Cat.toCatUI(): CatUI {
    return CatUI(
        id = this.id,
        imageUrl = this.imageUrl,
        breed = this.breed,
        country = this.country,
        description = this.description,
        temperament = this.temperament,
        isFavorite = this.isFavorite,
    )
}

internal fun CatUI.toCat(): Cat {
    return Cat(
        id = this.id,
        imageUrl = this.imageUrl,
        breed = this.breed,
        country = this.country,
        description = this.description,
        temperament = this.temperament,
        isFavorite = this.isFavorite,
    )
}