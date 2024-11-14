package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CatsDao {
    @Query("SELECT * FROM favorite_cats")
    suspend fun getAll() : List<CatsDBO>

    @Query("SELECT * FROM favorite_cats WHERE catId = :catId LIMIT 1")
    suspend fun get(catId: String): CatsDBO?

    @Insert
    suspend fun insert(cat: CatsDBO)

    @Query("DELETE FROM favorite_cats WHERE catId = :catId")
    suspend fun delete(catId: String)
}