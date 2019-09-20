package com.lambdaschool.datapersistencesprintchallenge.repo

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.lambdaschool.datapersistencesprintchallenge.db.FileManagementInterface
import com.lambdaschool.datapersistencesprintchallenge.db.MovieDB
import com.lambdaschool.datapersistencesprintchallenge.retro.RetroInstance
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import com.lambdaschool.sprint4challenge_mymovies.model.MovieSearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val repository: FileManagementInterface by lazy {
    App.repository!!
}

class App: Application(){
    companion object{
        var repository: FileManagementInterface? = null
    }

    override fun onCreate() {
        super.onCreate()
        repository = MovieRepo(applicationContext)
    }
}

class MovieRepo(context: Context): FileManagementInterface{
    private val database by lazy {
        Room.databaseBuilder(
            context.applicationContext,
            MovieDB::class.java, "movie_db"
        ).fallbackToDestructiveMigration().build()
    }

    override fun buildMovieOverviewList(): MutableList<MovieOverview> {
        return database.movieDao().buildMovieOverviewList()
    }

    override fun createMovieOverview(movieInfo: MovieOverview) {
        database.movieDao().createMovieOverview(movieInfo)
    }

    override fun updateMovieOverview(movieInfo: MovieOverview) {
        database.movieDao().updateMovieOverview(movieInfo)
    }

    override fun deleteMovieOverview(movieInfo: MovieOverview) {
        database.movieDao().deleteMovieOverview(movieInfo)
    }

    fun getRetroFitInstance(searchText: String): MutableList<MovieOverview>{
        var searchList: MutableList<MovieOverview> = mutableListOf()
        RetroInstance.getMovieSearchResults(searchText).enqueue(object :
            Callback<MovieSearchResult> {
            override fun onFailure(call: Call<MovieSearchResult>, t: Throwable) {
            }

            override fun onResponse(call: Call<MovieSearchResult>, response: Response<MovieSearchResult>) {
                val movies = response.body() as MovieSearchResult
                searchList = movies.results
            }
        })
        return searchList
    }

}