package com.lambdaschool.datapersistencesprintchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.R
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import kotlinx.android.synthetic.main.search_content.view.*

class SearchRecycler(private val movies: MutableList<MovieOverview>) :
    RecyclerView.Adapter<SearchRecycler.ViewHolder>() {
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_content, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val searchMovies = movies[position]

        holder.name.text = searchMovies.title
        holder.year.text = searchMovies.release_date

        holder.llayout.setOnClickListener {

        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.name
        val year: TextView = view.year
        val llayout: LinearLayout = view.linear_layout
    }
}