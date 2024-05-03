package com.example.simplecatsfactapplication.util

import androidx.room.Entity
import androidx.room.PrimaryKey

//to store facts
@Entity(tableName = "cat_facts")
data class CatFactEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fact: String
)