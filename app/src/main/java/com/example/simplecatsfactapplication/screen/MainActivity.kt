package com.example.simplecatsfactapplication.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.simplecatsfactapplication.*
import com.example.simplecatsfactapplication.api.CatFactService
import com.example.simplecatsfactapplication.repository.CatFactRepository
import com.example.simplecatsfactapplication.ui.theme.CatFactAppTheme
import com.example.simplecatsfactapplication.viewmodel.CatFactViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//main activity to display the facts
class MainActivity : ComponentActivity() {
    private lateinit var database: CatFactsDatabase

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val catFactService = retrofit.create(CatFactService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialise room database
        database = Room.databaseBuilder(
            applicationContext,
            CatFactsDatabase::class.java, "cat-facts-db"
        ).build()

        val catFactDao = database.catFactDao()
        val catFactRepository = CatFactRepository(catFactService, catFactDao)


        setContent {
            CatFactAppTheme {
                CatFactScreen(viewModel = CatFactViewModel(catFactRepository))
            }
        }
    }
}