package com.example.simplecatsfactapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplecatsfactapplication.repository.CatFactRepository
import com.example.simplecatsfactapplication.api.CatFactService
import com.example.simplecatsfactapplication.util.CatFactsDao
import kotlinx.coroutines.launch

class CatFactViewModel(private val repository: CatFactRepository) : ViewModel() {

    constructor(catFactService: CatFactService, catFactDao: CatFactsDao) :
            this(CatFactRepository(catFactService, catFactDao))


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