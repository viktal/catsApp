package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_cats")
data class CatsDBO (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo("catId") val catId: String,
    @ColumnInfo("url") val url: String?,
    @ColumnInfo("temperament") val temperament: String?,
    @ColumnInfo("origin") val origin: String?,
    @ColumnInfo("description") val description: String?,
)
