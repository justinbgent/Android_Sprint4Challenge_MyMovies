package com.lambdaschool.datapersistencesprintchallenge.retro

import com.lambdaschool.sprint4challenge_mymovies.model.MovieSearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("UserSearch")
    fun getSearch(@Query("Language")language: String,
                  @Path("UserSearch")userSearch: String): Call<MovieSearchResult>
}