package com.example.finalproject.data.repository

import android.util.Log
import com.example.finalproject.data.model.Fact
import com.example.finalproject.data.network.RetrofitClient

// Repository class for fetching facts from API and Room database
class FactsRepository {
    // fetches a random fact from the API
    suspend fun fetchRandomFact(): Fact {
        val response = RetrofitClient.apiService.getRandomFact()
        Log.d("FactsRepository.fetchRandomFact", "Fact: ${response.text}")
        return response
    }

    // fetches the fact for today from the API
    suspend fun fetchFactForToday(): Fact {
        val response = RetrofitClient.apiService.getFactForToday()
        Log.d("FactsRepository.fetchFactForToday", "Fact: ${response.text}")
        return response
    }
}