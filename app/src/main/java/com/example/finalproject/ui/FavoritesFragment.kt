package com.example.finalproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.database.FactDatabase
import com.example.finalproject.data.repository.FactsRepository
import com.example.finalproject.ui.adapter.FactAdapter
import com.example.finalproject.ui.viewmodel.FactViewModel
import com.example.finalproject.ui.viewmodel.FactViewModelFactory

class FavoritesFragment : Fragment() {

    private val factViewModel: FactViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            FactViewModelFactory(FactsRepository(FactDatabase.getInstance(requireContext()).factDao()))
        ).get(FactViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the RecyclerView and observe the favorite facts
        val favoritesRecyclerView = view.findViewById<RecyclerView>(R.id.favoritesRecyclerView)
        favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        factViewModel.favoriteFacts.observe(viewLifecycleOwner) { favoriteFacts ->
            favoritesRecyclerView.adapter = FactAdapter(favoriteFacts) { factEntity ->
                // Long-press callback to remove an item
                factViewModel.removeFromFavorites(factEntity)
                Toast.makeText(requireContext(), "Removed from favorites", Toast.LENGTH_SHORT).show()
            }
        }
    }
}