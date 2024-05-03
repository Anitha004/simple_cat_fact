package com.example.simplecatsfactapplication.repository

import com.example.simplecatsfactapplication.model.CatFact
import com.example.simplecatsfactapplication.api.CatFactService
import com.example.simplecatsfactapplication.util.CatFactsDao
import com.example.simplecatsfactapplication.util.CatFactEntity
import kotlinx.coroutines.flow.Flow

//repository to handle api calls
class CatFactRepository(private val catFactService: CatFactService, private val catFactDao: CatFactsDao) {
    suspend fun fetchCatFact(): CatFact {
        return catFactService.getCatFact()
    }

    suspend fun saveCatFact(catFact: CatFact) {
        catFactDao.insert(CatFactEntity(fact = catFact.fact))
    }

    fun getAllCatFacts(): Flow<List<CatFactEntity>> {
        return catFactDao.getAllCatFactsFlow()
    }
}