package com.example.finalproject.data.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.finalproject.data.model.Fact
import java.util.concurrent.Executors

@Database(entities = [Fact::class], version = 1, exportSchema = false)
abstract class FactDatabase : RoomDatabase() {
    abstract fun factDao(): FactDao

    companion object {
        private var factDatabase: FactDatabase? = null

        fun getInstance(context: Context): FactDatabase {
            return factDatabase ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactDatabase::class.java,
                    "favorite_fact_database"
                )
                .setQueryCallback({ sqlQuery, bindArgs ->
                    Log.d("RoomQuery", "SQL: $sqlQuery, args: $bindArgs")
                }, Executors.newSingleThreadExecutor())
                .build()
                factDatabase = instance
                instance
            }
        }
    }
}