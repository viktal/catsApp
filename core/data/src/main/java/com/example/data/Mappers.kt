package com.example.data

import com.example.cats_api.models.ResponseDTO
import com.example.data.model.Cat
import com.example.database.CatsDBO

internal fun ResponseDTO.toCats(): Cat {
    return Cat(
        id = this.id,
        imageUrl = this.url,
        breed = this.breeds?.map { it.name }?.joinToString(),
        country = this.breeds?.map { it.origin }?.joinToString(),
        description = this.breeds?.map { it.description }?.joinToString(),
        temperament = this.breeds?.map { it.temperament }?.joinToString(),
        isFavorite = false,
    )
}

internal fun Cat.toCatDBO(): CatsDBO {
    return CatsDBO(
        catId = this.id,
        url = this.imageUrl,
        temperament = this.temperament,
        origin = this.country,
        description = this.description,
    )
}
