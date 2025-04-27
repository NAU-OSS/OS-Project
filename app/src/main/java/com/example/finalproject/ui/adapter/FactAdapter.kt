package com.example.finalproject.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.model.Fact

class FactAdapter(
    private var facts: List<Fact>,
    private val onRemoveClick: (Fact) -> Unit
) : RecyclerView.Adapter<FactAdapter.FactViewHolder>() {

    // ViewHolder class to hold the views for each item
    class FactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val factText: TextView = view.findViewById(R.id.fact_textview)
        val removeButton: Button = view.findViewById(R.id.remove_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fact, parent, false)
        return FactViewHolder(view)
    }

    override fun onBindViewHolder(holder: FactViewHolder, position: Int) {
        val fact = facts[position]

        // Bind the fact text to the TextView
        holder.factText.text = fact.text

        // Handle long press event to trigger the removal callback
        holder.removeButton.setOnClickListener {
            onRemoveClick(fact)
        }
    }

    override fun getItemCount(): Int = facts.size

//    // Function to update the list of facts
//    // not sure if needed
//    fun updateFacts(newFacts: List<Fact>) {
//        facts = newFacts
//        notifyDataSetChanged()
//    }

}