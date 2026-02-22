package com.takeda.rickyandmorty.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.takeda.rickyandmorty.network.resultData
import org.intellij.lang.annotations.JdkConstants

@Composable
fun Card(data: resultData) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth().height(96.dp)
    ) {
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            AsyncImage(
                model = data.image,
                contentDescription = null
            )
            Column {
                Text(text = "${data.name} (${data.status})")
                Text(text = data.species)
            }
        }
    }
}