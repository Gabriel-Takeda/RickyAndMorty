package com.takeda.rickyandmorty.ui.screens.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.takeda.rickyandmorty.network.RickyAndMortyData
import com.takeda.rickyandmorty.ui.components.Card
import org.jetbrains.annotations.Async

@Composable
fun HomeScreen(
    rickyAndMortyUiState: RickyAndMortyUiState,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues,
) {
    Column (modifier = Modifier.padding(contentPaddingValues)) {
        when(rickyAndMortyUiState) {
            is RickyAndMortyUiState.Success -> SuccessScreen(rickyAndMortyUiState.rickyAndMortyDataResponse,
                modifier = Modifier.fillMaxSize())
            is RickyAndMortyUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
            is RickyAndMortyUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
        }
    }


}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Loading",
        modifier = modifier)
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Text(text = "Error",
        modifier = modifier)
}

@Composable
fun SuccessScreen(rickyAndMortyDataResponse: RickyAndMortyData, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.padding(16.dp, 0.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(rickyAndMortyDataResponse.results) {result ->
            Card(result)
        }
    }

}