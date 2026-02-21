package com.takeda.rickyandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.takeda.rickyandmorty.ui.RickyAndMortyApp
import com.takeda.rickyandmorty.ui.screens.HomeScreen.RickyAndMortyViewModel
import com.takeda.rickyandmorty.ui.theme.RIckyAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RIckyAndMortyTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RickyAndMortyApp()
                }
            }
        }
    }
}