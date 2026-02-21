package com.takeda.rickyandmorty.ui.screens.HomeScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.takeda.rickyandmorty.network.RickyAndMortyData

@Composable
fun HomeScreen(
    rickyAndMortyUiState: RickyAndMortyUiState,
    contentPaddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    when(rickyAndMortyUiState) {
        is RickyAndMortyUiState.Success -> SuccessScreen(rickyAndMortyUiState.rickyAndMortyDataResponse)
        is RickyAndMortyUiState.Error -> ErrorScreen()
        is RickyAndMortyUiState.Loading -> LoadingScreen()
    }

}

@Composable
fun LoadingScreen() {
    Text(text = "Loading")
}

@Composable
fun ErrorScreen() {
    Text(text = "Error")
}

@Composable
fun SuccessScreen(rickyAndMortyDataResponse: RickyAndMortyData) {
    Text(text = "tamanho do resultado: ${rickyAndMortyDataResponse.results.size}")
}