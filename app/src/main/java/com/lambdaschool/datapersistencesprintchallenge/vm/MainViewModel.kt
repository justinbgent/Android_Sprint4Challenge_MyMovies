package com.lambdaschool.datapersistencesprintchallenge.vm

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.adapter.SearchRecycler
import com.lambdaschool.datapersistencesprintchallenge.repo.MovieRepo
import com.lambdaschool.datapersistencesprintchallenge.repo.repository
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

class MainViewModel(context: Context): ViewModel() {
    private val movieRepo = MovieRepo(context)

    fun setupRecyclerWithRetro(text: String, recyclerView: RecyclerView){
        recyclerView.setHasFixedSize(true)
        val manager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        val adapter = SearchRecycler(sendSearchTextToRetro(text))
        recyclerView.adapter = adapter
    }

    private fun sendSearchTextToRetro(text: String): MutableList<MovieOverview>{
        return movieRepo.getRetroFitInstance(text)
    }
}


class AddAsyncTask(private val movieOverview: MovieOverview): AsyncTask<Void, Void, Unit>(){
    override fun doInBackground(vararg p0: Void?) {
        repository.createMovieOverview(movieOverview)
    }
}

class UpdateAsyncTask(private val movieOverview: MovieOverview): AsyncTask<Void, Void, Unit>(){
    override fun doInBackground(vararg p0: Void?) {
        repository.updateMovieOverview(movieOverview)
    }
}