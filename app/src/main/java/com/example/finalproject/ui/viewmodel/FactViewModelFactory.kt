package com.example.finalproject.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.data.repository.FactsRepository

class FactViewModelFactory(private val repository: FactsRepository) : ViewModelProvider.Factory {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FactViewModel::class.java)) {
            return FactViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}