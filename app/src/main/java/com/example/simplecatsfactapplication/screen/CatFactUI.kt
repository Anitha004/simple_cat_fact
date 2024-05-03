package com.example.simplecatsfactapplication.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecatsfactapplication.viewmodel.CatFactViewModel

//main compose UI
@Composable
fun CatFactUI(viewModel: CatFactViewModel) {
    val catFacts by viewModel.catFactsFlow.collectAsState(initial = emptyList())

    // to show the current fact index
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),Arrangement.Center,Alignment.CenterHorizontally
    ) {
        Text(text = "Fact ${currentIndex + 1} of ${catFacts.size}:")
        Text(text = catFacts.getOrNull(currentIndex)?.fact ?: "No facts available")

        Button(
            onClick = {
                currentIndex = (currentIndex + 1) % catFacts.size
            },
            enabled = catFacts.isNotEmpty()
        ) {
            Text(text = "Next Fact")
        }

        Button(
            onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else catFacts.lastIndex
            },
            enabled = catFacts.isNotEmpty()
        ) {
            Text(text = "Previous Fact")
        }
    }

    // fetching a new fact on screen
    LaunchedEffect(true) {
        viewModel.fetchAndSaveCatFact()
    }
}