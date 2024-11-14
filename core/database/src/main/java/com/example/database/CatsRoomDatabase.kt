package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CatsDBO::class], version = 1)
abstract class CatsRoomDatabase : RoomDatabase() {
    abstract fun catsDao(): CatsDao
}

fun CatsDatabase(applicationContext: Context): CatsRoomDatabase {
    return Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            CatsRoomDatabase::class.java,
            "cats"
        ).build()
}