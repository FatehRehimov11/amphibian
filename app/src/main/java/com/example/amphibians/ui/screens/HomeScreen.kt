package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.ui.theme.AmphibiansTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.model.AmphibianCardUiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: AmphibianUiState
){
    when(uiState){
        is AmphibianUiState.Loading -> LoadingScreen()
        is AmphibianUiState.Error -> ErrorScreen()
        is AmphibianUiState.Success -> LazyColumnScreen(uiState.amphibianCards)
    }

}

@Composable
fun LoadingScreen(){
    Image(
        contentDescription = "",
        painter = painterResource(R.drawable.ic_launcher_foreground)
    )
}
@Composable
fun ErrorScreen(){
    Image(
        contentDescription = "",
        painter = painterResource(R.drawable.ic_launcher_background)
    )
}
@Composable
fun LazyColumnScreen(amphibianCards: List<AmphibianCardUiState>){
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = amphibianCards){ item ->
            AmphibianCard(item)
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun Pew(){
//    AmphibiansTheme {
//        HomeScreen()
//    }
//}