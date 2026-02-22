package com.takeda.rickyandmorty.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.takeda.rickyandmorty.ui.screens.HomeScreen.HomeScreen
import com.takeda.rickyandmorty.ui.screens.HomeScreen.RickyAndMortyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.takeda.rickyandmorty.ui.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RickyAndMortyApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val rickyAndMortyViewModel: RickyAndMortyViewModel = viewModel()
            HomeScreen(
                contentPaddingValues = it,
                rickyAndMortyUiState = rickyAndMortyViewModel.rickyAndMortyUiState,
            )
        }
    }
}