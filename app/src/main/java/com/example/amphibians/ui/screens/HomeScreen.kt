package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    uiState: AmphibianUiState,
    retryAction: () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        when(uiState){
            is AmphibianUiState.Loading -> LoadingScreen()
            is AmphibianUiState.Error -> ErrorScreen(retryAction)
            is AmphibianUiState.Success -> LazyColumnScreen(uiState.amphibianCards)
        }
    }


}

@Composable
fun LoadingScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.ic_launcher_foreground)
        )
    }

}
@Composable
fun ErrorScreen(retryAction: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = "",
            painter = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier.clickable(enabled = true, onClick = retryAction)
        )
    }
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