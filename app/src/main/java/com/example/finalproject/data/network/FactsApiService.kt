package com.example.finalproject.data.network

import com.example.finalproject.data.model.Fact
import retrofit2.http.GET

interface FactsApiService {
    // fetch a random fact
    @GET("random")
    suspend fun getRandomFact(): Fact

    // fetch the fact for today
    @GET("today")
    suspend fun getFactForToday(): Fact
}