package com.lambdaschool.datapersistencesprintchallenge.retro

data class MoviesJsonSearch(val results: MutableList<MovieObj>)

data class MovieObj(val title: String, val release_date: String)