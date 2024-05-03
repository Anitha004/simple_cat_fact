package com.example.simplecatsfactapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplecatsfactapplication.util.CatFactEntity
import com.example.simplecatsfactapplication.util.CatFactsDao

//room database for storing data
@Database(entities = [CatFactEntity::class], version = 1, exportSchema = false)
abstract class CatFactsDatabase : RoomDatabase() {
    abstract fun catFactDao(): CatFactsDao
}
