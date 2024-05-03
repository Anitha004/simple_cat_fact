package com.example.simplecatsfactapplication.util

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.simplecatsfactapplication.util.CatFactEntity
import kotlinx.coroutines.flow.Flow

//queries to handle the data
@Dao
interface CatFactsDao { @Insert
        suspend fun insert(catFact: CatFactEntity)

        @Query("SELECT * FROM cat_facts")
        fun getAllCatFactsFlow(): Flow<List<CatFactEntity>>

        @Query("SELECT * FROM cat_facts")
        fun getAllCatFacts(): List<CatFactEntity>

}