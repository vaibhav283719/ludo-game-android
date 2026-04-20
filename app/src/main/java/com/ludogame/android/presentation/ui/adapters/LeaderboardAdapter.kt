package com.ludogame.android.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ludogame.android.R

class LeaderboardAdapter(
    private var items: List<Pair<String, Int>> = emptyList()
) : RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_leaderboard, parent, false)
    ) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val score: TextView = itemView.findViewById(R.id.tvScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.name.text = item.first
        holder.score.text = item.second.toString()
    }

    override fun getItemCount(): Int = items.size

    fun submit(newItems: List<Pair<String, Int>>) {
        items = newItems
        notifyDataSetChanged()
    }
}
