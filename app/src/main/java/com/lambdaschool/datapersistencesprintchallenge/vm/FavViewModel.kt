package com.lambdaschool.datapersistencesprintchallenge.vm

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.adapter.SearchRecycler
import com.lambdaschool.datapersistencesprintchallenge.repo.repository
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

class FavViewModel(context: Context): ViewModel() {
    fun setupRecyclerView(recyclerView: RecyclerView, favMoviesList: MutableList<MovieOverview>){
        recyclerView.setHasFixedSize(true)
        val manager = LinearLayoutManager(recyclerView.context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = manager
        val adapter = SearchRecycler(favMoviesList)
        recyclerView.adapter = adapter
    }
}

class BuildAsyncTask(context: Context): AsyncTask<Void, Void, MutableList<MovieOverview>>(){
    interface SetupRecycler{
        fun getRecyclerList(favMoviesList: MutableList<MovieOverview>)
    }

    companion object{
        var listener: SetupRecycler? = null
    }

    init {
        if(context is SetupRecycler){
            listener = context
        }
    }


    override fun doInBackground(vararg p0: Void?): MutableList<MovieOverview> {
        return repository.buildMovieOverviewList()
    }

    override fun onPostExecute(result: MutableList<MovieOverview>?) {
        super.onPostExecute(result)
        if (result != null){
            listener?.getRecyclerList(result)
        }
    }
}

class DeleteAsyncTask(private val movieOverview: MovieOverview): AsyncTask<Void, Void, Unit>(){
    override fun doInBackground(vararg p0: Void?) {
        repository.deleteMovieOverview(movieOverview)
    }
}
