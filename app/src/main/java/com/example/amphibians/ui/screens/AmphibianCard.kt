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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            Image(
                contentDescription = "",
                painter = painterResource(R.drawable.ic_launcher_background),
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