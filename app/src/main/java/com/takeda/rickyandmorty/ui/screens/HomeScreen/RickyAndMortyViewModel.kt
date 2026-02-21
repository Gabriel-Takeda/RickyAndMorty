package com.takeda.rickyandmorty.ui.screens.HomeScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.takeda.rickyandmorty.network.RickyAndMortyApi
import com.takeda.rickyandmorty.network.RickyAndMortyData
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface RickyAndMortyUiState {
    data class Success (val rickyAndMortyDataResponse : RickyAndMortyData): RickyAndMortyUiState
    object Error: RickyAndMortyUiState
    object Loading: RickyAndMortyUiState
}

class RickyAndMortyViewModel: ViewModel() {

    var rickyAndMortyUiState: RickyAndMortyUiState by mutableStateOf(RickyAndMortyUiState.Loading)
        private set

    init {
        getRickyAndMortyResponse()
    }

    fun getRickyAndMortyResponse() {
        viewModelScope.launch {
            rickyAndMortyUiState = try {
                val listResponse = RickyAndMortyApi.retrofitService.getCharacter(1)
                Log.d("teste", "teste")
                RickyAndMortyUiState.Success(listResponse)
            } catch (e: Exception) {
                RickyAndMortyUiState.Error
            }
        }
    }
}