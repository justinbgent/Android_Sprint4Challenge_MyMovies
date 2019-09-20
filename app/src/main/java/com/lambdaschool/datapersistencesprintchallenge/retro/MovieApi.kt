package com.lambdaschool.datapersistencesprintchallenge.retro

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("UserSearch")
    fun getSearch(@Path("UserSearch")userSearch: String): Call<MoviesJsonSearch>
}