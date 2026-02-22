package com.takeda.rickyandmorty.ui.screens.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
    Column (modifier = modifier.padding(contentPaddingValues).fillMaxSize()) {
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
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Loading")

    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.Warning, contentDescription = null)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Something went wrong")
    }
}

@Composable
fun SuccessScreen(rickyAndMortyDataResponse: RickyAndMortyData, modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.padding(16.dp, 0.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(rickyAndMortyDataResponse.results) {result ->
            Card(result)
        }
    }

}