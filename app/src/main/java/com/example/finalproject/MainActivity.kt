package com.example.finalproject

import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.finalproject.data.database.FactDatabase
import com.example.finalproject.data.repository.FactsRepository
import com.example.finalproject.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_daily_fact, R.id.nav_browse_facts, R.id.nav_favorites
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // tests (delete this later!)
        val factsRepository = FactsRepository(FactDatabase.getInstance(this).factDao())

        lifecycleScope.launch {
            try {
                // fetch a random fact
                val randomFact = factsRepository.fetchRandomFact()
                Log.d("MainActivity", "Random Fact: ${randomFact.text}")

                // fetch the fact for today
                val factForToday = factsRepository.fetchFactForToday()
                Log.d("MainActivity", "Fact for Today: ${factForToday.text}")

                // add the facts to favorites
                factsRepository.addFavoriteFact(randomFact)
                factsRepository.addFavoriteFact(factForToday)
                Log.d("MainActivity", "Added Facts: ${randomFact.text}, ${factForToday.text}")

                // get the list of favorite facts
                val favoriteFacts = factsRepository.getFavoriteFacts()
                val currentFavorites = favoriteFacts.first()
                Log.d("MainActivity", "Favorite Facts: ${currentFavorites.joinToString { it.text }}")

                // remove a fact from favorites
                factsRepository.removeFavoriteFact(randomFact)
                Log.d("MainActivity", "Removed Fact: ${randomFact.text}")

                delay(100)

                // verify removal
                val updatedFavoriteFacts = factsRepository.getFavoriteFacts()
                val updatedFavorites = updatedFavoriteFacts.first()
                Log.d("MainActivity", "Updated Favorite Facts: ${updatedFavorites.joinToString { it.text }}")
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching facts: ${e.message}")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}