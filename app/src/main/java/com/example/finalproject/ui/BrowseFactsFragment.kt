package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.R
import com.example.finalproject.data.database.FactDatabase
import com.example.finalproject.data.repository.FactsRepository
import com.example.finalproject.ui.viewmodel.FactViewModel
import com.example.finalproject.ui.viewmodel.FactViewModelFactory

class BrowseFactsFragment : Fragment() {

    private lateinit var factViewModel: FactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // initialize the viewmodel
        val application = requireActivity().application
        val factDatabase = FactDatabase.getInstance(application)
        val repository = FactsRepository(factDatabase.factDao())
        val factory = FactViewModelFactory(repository)
        factViewModel = ViewModelProvider(requireActivity(), factory).get(FactViewModel::class.java)

        return inflater.inflate(R.layout.fragment_browse_facts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // references to UI elements
        val textBrowseFacts = view.findViewById<TextView>(R.id.text_browse_facts)
        val generateNewFactButton = view.findViewById<Button>(R.id.new_random_fact)
        val addToFavoritesButton = view.findViewById<Button>(R.id.add_to_favorites)

        // observe the random fact and update the UI
        factViewModel.randomFact.observe(viewLifecycleOwner) { fact ->
            // Update your UI with the fact data here
            textBrowseFacts.text = fact.text

            val favoriteList = factViewModel.favoriteFacts.value ?: emptyList()
            val isFavorite = favoriteList.any { it.id == fact.id }

            // set the button test based on favorite status
            addToFavoritesButton.text = if(isFavorite) {
                "Added to Favorites"
            } else {
                "Add to Favorites"
            }

            // handle favorites button click listener
            addToFavoritesButton.setOnClickListener {
                val currentFavoriteList = factViewModel.favoriteFacts.value ?: emptyList()
                val currentFavorite = currentFavoriteList.any { it.id == fact.id }

                // if its in favorites then the button will display removed
                if (!currentFavorite) {
                    factViewModel.addToFavorites(fact)
                    Toast.makeText(requireContext(), "Added to Favorites!", Toast.LENGTH_SHORT).show()
                    addToFavoritesButton.text = "Added to Favorites"
                } else {
                    Toast.makeText(requireContext(), "Already added to Favorites!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // fetch a new daily fact when the fragment is created
        factViewModel.fetchRandomFact()

        // handle the generate new fact button click
        generateNewFactButton.setOnClickListener {
            factViewModel.fetchRandomFact()
            Toast.makeText(requireContext(), "New fact generated!", Toast.LENGTH_SHORT).show()
        }
    }
}