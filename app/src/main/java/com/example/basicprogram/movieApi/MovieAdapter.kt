package com.example.basicprogram.movieApi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basicprogram.R
import com.squareup.picasso.Picasso

class MovieAdapter(private var movieList: ArrayList<MoviesItem>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        holder.movieName.text = movieList[position].name
        holder.movieBio.text = movieList[position].publisher
        holder.movieRealName.text = movieList[position].realname
        Picasso.get().load(movieList[position].imageurl).into(holder.movieImg)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieName: TextView = itemView.findViewById(R.id.name)
        val movieBio: TextView = itemView.findViewById(R.id.bio)
        val movieRealName: TextView = itemView.findViewById(R.id.real_name)
        val movieImg: ImageView = itemView.findViewById(R.id.img_url)

    }
}
