package com.example.finalproject.data.repository

import android.util.Log
import com.example.finalproject.data.database.FactDao
import com.example.finalproject.data.model.Fact
import com.example.finalproject.data.network.RetrofitClient
import kotlinx.coroutines.flow.Flow

// Repository class for fetching facts from API and Room database
class FactsRepository(private val factDao: FactDao) {
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

    // add a fact to favorites
    suspend fun addFavoriteFact(fact: Fact) {
        try {
            factDao.addFavoriteFact(fact)
        } catch (e: Exception) {
            Log.d("FactsRepository", "${fact.text} already in favorites")
        }
    }

    // get list of favorite facts from the database
    fun getFavoriteFacts(): Flow<List<Fact>> {
        return factDao.getFavoriteFacts()
    }

    // remove a fact from favorites
    suspend fun removeFavoriteFact(fact: Fact) {
        factDao.removeFavoriteFact(fact)
    }
}