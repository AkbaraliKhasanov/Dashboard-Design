package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddashboard.databinding.ItemContainerMovieBinding
import com.example.models.Movie

class MoviesAdapter(private val list: ArrayList<Movie>) : RecyclerView.Adapter<MoviesAdapter.Vh>() {
    inner class Vh(private val binding: ItemContainerMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(movie: Movie) {
            binding.apply {
                imagePoster.setImageResource(movie.poster!!)
                ratingBar.rating = movie.rating!!
                textCategory.text = movie.category
                textName.text = movie.name
                textReleaseDate.text = movie.releaseDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemContainerMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}