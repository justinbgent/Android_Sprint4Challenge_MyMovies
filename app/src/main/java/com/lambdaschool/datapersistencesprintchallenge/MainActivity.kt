package com.lambdaschool.datapersistencesprintchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.datapersistencesprintchallenge.adapter.SearchRecycler
import com.lambdaschool.datapersistencesprintchallenge.retro.RetroInstance
import com.lambdaschool.datapersistencesprintchallenge.vm.MainViewModel
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview
import com.lambdaschool.sprint4challenge_mymovies.model.MovieSearchResult
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel(this)


        btn_search.setOnClickListener {
            mainViewModel.setupRecyclerWithRetro(search_et.text.toString(), search_recycler)
        }
    }
}

/*
* make my retrofit call work when I click search
* add click for favoriting items and change background color to show selection
* add long click listener to fav list items to delete
* finish async calls
* find out where to put @Entity in MovieOverview.kt
* perhaps use an interface as a listener
* */
