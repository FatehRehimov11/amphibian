package com.example.amphibians.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.ui.screens.AmphibianViewModel
import com.example.amphibians.ui.screens.HomeScreen

@Composable
fun AmphibianApp(modifier: Modifier = Modifier){
    val amphibianViewModel: AmphibianViewModel = viewModel(factory = AmphibianViewModel.Factory)
    Scaffold(
        topBar = {AmphibianAppTopBar()}
    ) {
        HomeScreen(
            modifier = modifier.padding(it),
            uiState = amphibianViewModel.amphibianUiState
        )
    }
}

@Composable
fun AmphibianAppTopBar(){

}