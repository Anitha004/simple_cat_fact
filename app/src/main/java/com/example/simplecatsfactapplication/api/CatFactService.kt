package com.example.simplecatsfactapplication.api

import com.example.simplecatsfactapplication.model.CatFact
import retrofit2.http.GET

//call get api to get cat facts
interface CatFactService {
    @GET("/fact")
    suspend fun getCatFact(): CatFact
}