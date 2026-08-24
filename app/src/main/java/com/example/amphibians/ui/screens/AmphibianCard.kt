package com.example.amphibians.ui.screens

import android.text.style.TtsSpan.TextBuilder
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.AmphibianCardUiState
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibianCard(item: AmphibianCardUiState){
    Card(
    ){
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            Text(
                text = item.name + " (" + item.type + ")"
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(item.image).crossfade(true).build(),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = item.description
            )
        }

    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun Peww(){
//    AmphibiansTheme {
//        AmphibianCard(
//            AmphibianCard()
//        )
//    }
//}