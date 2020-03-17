package com.lambdaschool.datapersistencesprintchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.adapter.FavoritesRecycler
import com.lambdaschool.datapersistencesprintchallenge.adapter.SearchRecycler
import com.lambdaschool.datapersistencesprintchallenge.vm.BuildAsyncTask
import com.lambdaschool.datapersistencesprintchallenge.vm.FavViewModel
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.activity_main.*

class FavoritesActivity : AppCompatActivity(), BuildAsyncTask.SetupRecycler {

    override fun getRecyclerList(favMoviesList: MutableList<MovieOverview>) {
        favViewModel.setupRecyclerView(fav_recycler, favMoviesList)
    }

    lateinit var favViewModel: FavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        favViewModel = FavViewModel(this)

        BuildAsyncTask(this)
    }

    fun setupRecycler(favMovies: MutableList<MovieOverview>){
        fav_recycler.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        fav_recycler.layoutManager = manager
        val adapter = FavoritesRecycler(favMovies)
        fav_recycler.adapter = adapter
        super.onResume()
    }
}
