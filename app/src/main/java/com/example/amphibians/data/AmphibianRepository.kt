package com.example.amphibians.data

import com.example.amphibians.model.AmphibianCardUiState
import com.example.amphibians.network.AmphibianApiService

interface AmphibianRepository{
    suspend fun getAmphibianCards(): List<AmphibianCardUiState>
}

class NetworkAmphibianRepository(val apiService: AmphibianApiService): AmphibianRepository{
    override suspend fun getAmphibianCards(): List<AmphibianCardUiState> = apiService.getCards()
}