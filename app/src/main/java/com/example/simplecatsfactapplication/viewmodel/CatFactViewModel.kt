package com.example.simplecatsfactapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplecatsfactapplication.repository.CatFactRepository
import com.example.simplecatsfactapplication.api.CatFactApiService
import com.example.simplecatsfactapplication.util.CatFactsDao
import kotlinx.coroutines.launch

class CatFactViewModel(private val repository: CatFactRepository) : ViewModel() {

    constructor(catFactApiService: CatFactApiService, catFactDao: CatFactsDao) :
            this(CatFactRepository(catFactApiService, catFactDao))


    fun fetchAndSaveCatFact() {
        viewModelScope.launch {
            val catFact = repository.fetchCatFact()
            repository.saveCatFact(catFact)
        }
    }

    val catFactsFlow = repository.getAllCatFacts()

    init {
        viewModelScope.launch {
            repository.getAllCatFacts().collect {
            }
        }
    }
}