package com.example.simplecatsfactapplication.repository

import com.example.simplecatsfactapplication.model.CatFactResponse
import com.example.simplecatsfactapplication.api.CatFactApiService
import com.example.simplecatsfactapplication.util.CatFactsDao
import com.example.simplecatsfactapplication.util.CatFactEntity
import kotlinx.coroutines.flow.Flow

//repository to handle api calls
class CatFactRepository(private val catFactApiService: CatFactApiService, private val catFactDao: CatFactsDao) {
    suspend fun fetchCatFact(): CatFactResponse {
        return catFactApiService.getCatFact()
    }

    suspend fun saveCatFact(catFactResponse: CatFactResponse) {
        catFactDao.insert(CatFactEntity(fact = catFactResponse.fact))
    }

    fun getAllCatFacts(): Flow<List<CatFactEntity>> {
        return catFactDao.getAllCatFactsFlow()
    }
}