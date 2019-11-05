package com.example.secondapiretro.Adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.secondapiretro.MainActivity
import com.example.secondapiretro.Movies
import com.example.secondapiretro.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*

class MovieViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView) {
    val context = context

    fun setData(Movie: Movies){
        itemView.tv_title.text=Movie.title
        itemView.tv_year.text=Movie.year.toString()
        itemView.tv_genre.text=Movie.genres.toString()
        val id=Movie.id
        val movieImg = Movie.medium_cover_image.toString()
        Glide.with(context)
            .load(movieImg)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(itemView.imgView)
    }
}