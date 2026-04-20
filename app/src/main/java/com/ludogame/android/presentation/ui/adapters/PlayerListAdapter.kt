package com.ludogame.android.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ludogame.android.R

class PlayerListAdapter(
    private var players: List<String> = emptyList()
) : RecyclerView.Adapter<PlayerListAdapter.ViewHolder>() {

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
    ) {
        val name: TextView = itemView.findViewById(R.id.tvPlayerName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = players[position]
    }

    override fun getItemCount(): Int = players.size

    fun submit(newPlayers: List<String>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}
