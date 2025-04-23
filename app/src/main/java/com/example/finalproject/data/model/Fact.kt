package com.example.finalproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_facts")
data class Fact(
    @PrimaryKey val id: String,
    val text: String
)