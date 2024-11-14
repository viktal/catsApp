package com.example.data

import com.example.cats_api.models.BreedDTO
import com.example.cats_api.models.ResponseDTO
import com.example.data.model.Breed
import com.example.data.model.Cat

internal fun ResponseDTO.toCats(): Cat {
    return Cat(
        id = this.id,
        url = this.url,
        width = this.width,
        height = this.height,
        breed = this.breeds?.map { it.toBreed() },
    )
}

internal fun BreedDTO.toBreed(): Breed {
    return Breed(
        id = this.id,
        name = this.name,
        temperament = this.temperament,
        origin = this.origin,
        description = this.description,
    )
}
