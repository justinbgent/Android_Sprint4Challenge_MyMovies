package com.lambdaschool.datapersistencesprintchallenge.retro

import com.google.gson.GsonBuilder
import com.lambdaschool.sprint4challenge_mymovies.apiaccess.MovieConstants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private const val BASE_URL = MovieConstants.TO_SEARCH

    fun getMovieSearchResults(userSearch: String): Call<MoviesJsonSearch>{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(MovieApi::class.java).getSearch(userSearch)
    }
}