package com.example.amphibians.network

import com.example.amphibians.model.AmphibianCardUiState
import retrofit2.http.GET

interface AmphibianApiService {
    @GET("amphibians")
    suspend fun getCards(): List<AmphibianCardUiState>
}