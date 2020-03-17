package com.lambdaschool.datapersistencesprintchallenge.retro

import com.google.gson.GsonBuilder
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.MovieConstants
import com.lambdaschool.sprint4challenge_mymovies.model.MovieSearchResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
//    private const val BASE_URL = MovieConstants.TO_SEARCH

    fun getMovieSearchResults(userSearch: String): Call<MovieSearchResult>{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(MovieConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

//        val asdf = retrofit.create(MovieApi::class.java).getSearch(MovieConstants.TO_SEARCH, userSearch)
        return retrofit.create(MovieApi::class.java).getSearch(MovieConstants.TO_SEARCH, userSearch)
    }
}