package com.example.simplecatsfactapplication.api

import com.example.simplecatsfactapplication.model.CatFactResponse
import retrofit2.http.GET

//call get api to get cat facts
interface CatFactApiService {
    @GET("/fact")
    suspend fun getCatFact(): CatFactResponse
}