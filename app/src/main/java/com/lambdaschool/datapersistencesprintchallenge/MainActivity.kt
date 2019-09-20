package com.lambdaschool.datapersistencesprintchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.adapter.SearchRecycler
import com.lambdaschool.datapersistencesprintchallenge.retro.RetroInstance
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import com.lambdaschool.sprint4challenge_mymovies.model.MovieSearchResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            RetroInstance.getMovieSearchResults(search_et.text.toString()).enqueue(object :
                Callback<MovieSearchResult>{
                override fun onFailure(call: Call<MovieSearchResult>, t: Throwable) {
                }

                override fun onResponse(call: Call<MovieSearchResult>, response: Response<MovieSearchResult>) {
                    val movies = response.body() as MovieSearchResult
                    setupRecycler(movies.results)
                }
            })
        }
    }

    fun setupRecycler(searchResults: MutableList<MovieOverview>){
        search_recycler.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        search_recycler.layoutManager = manager
        val adapter = SearchRecycler(searchResults)
        search_recycler.adapter = adapter
        super.onResume()
    }
}
