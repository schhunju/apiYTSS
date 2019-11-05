package com.example.secondapiretro.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.secondapiretro.MovieDetails
import com.example.secondapiretro.Movies
import com.example.secondapiretro.R

class MovieAdapter(val context: Context, val movie:List<Movies>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return MovieViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie=movie[position]
        holder.setData(movie)

        holder.itemView.setOnClickListener({
            val intent=Intent(context,MovieDetails(movie.id)::class.java)
            startActivity(context,intent,null)
        })
    }
}