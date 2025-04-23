package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.model.Fact
import com.example.finalproject.data.repository.FactsRepository
import kotlinx.coroutines.launch

class FactViewModel(private val repository: FactsRepository) : ViewModel() {
    // it is just one random fact at a time correct?
    private val _randomFact = MutableLiveData<Fact>()
    val randomFact: LiveData<Fact> get() = _randomFact

    private val _todayFact = MutableLiveData<Fact>()
    val todayFact: LiveData<Fact> get() = _todayFact

    val favoriteFacts: LiveData<List<Fact>> = repository.getFavoriteFacts().asLiveData()

    fun fetchRandomFact() {
        viewModelScope.launch {
            try {
                val response = repository.fetchRandomFact()
                // response file needed?
                _randomFact.value = response
            } catch (e: Exception) {
                println("Error getting random fact!: ${e.message}")
            }
        }
    }

    fun fetchFactForToday() {
        viewModelScope.launch {
            try {
                val response = repository.fetchFactForToday()
                _todayFact.value = response
            } catch (e: Exception) {
                println("Error getting today's fact!: ${e.message}")
            }
        }
    }

    fun addToFavorites(fact: Fact) {
        viewModelScope.launch {
            // might have to change the logic on this
            val favFactInList = repository.getFavoriteFacts().asLiveData().value
            if (favFactInList == null || favFactInList.find { it.id == fact.id } == null) {
                try {
                    repository.addFavoriteFact(fact)
                } catch (e: Exception) {
                    println("Error adding to favorite list!: ${e.message}")
                }
            }
        }
    }

    fun removeFromFavorites(fact: Fact) {
        viewModelScope.launch {
            try {
                repository.removeFavoriteFact(fact)
            } catch (e: Exception) {
                println("Error removing from favorite list!: ${e.message}")
            }
        }
    }
}