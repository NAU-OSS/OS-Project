package com.example.finalproject.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finalproject.data.model.Fact
import kotlinx.coroutines.flow.Flow

@Dao
interface FactDao {
    @Insert
    suspend fun addFavoriteFact(fact: Fact)

    @Query("SELECT * FROM favorite_facts")
    fun getFavoriteFacts(): Flow<List<Fact>>

    @Delete
    suspend fun removeFavoriteFact(fact: Fact)
}