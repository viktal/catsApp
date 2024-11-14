package com.example.data.database

import com.example.data.model.Cat
import com.example.data.toCatDBO
import com.example.database.CatsRoomDatabase

class DatabaseRepository(
    private val database: CatsRoomDatabase,
) {
    suspend fun saveFavorite(cat: Cat) {
        database.catsDao().insert(cat.toCatDBO())
    }

    suspend fun deleteFavorite(cat: Cat) {
        database.catsDao().delete(cat.id)
    }

    suspend fun getFavoriteCatsIds(): List<String> {
        return database.catsDao().getAll().map { catsDBO -> catsDBO.catId }
    }
}