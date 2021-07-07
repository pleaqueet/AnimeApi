package com.example.animeapi.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapi.R
import com.example.animeapi.model.AnimePost

class AnimeListAdapter(private val context: Context, private val anime: MutableList<AnimePost>) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeListViewHolder>() {

    inner class AnimeListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animeTitle = itemView.findViewById<TextView>(R.id.anime_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_anime, parent, false)

        return AnimeListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.animeTitle.text = anime[position].data.attributes.titles.en
    }

    override fun getItemCount(): Int {
        return anime.size
    }
}