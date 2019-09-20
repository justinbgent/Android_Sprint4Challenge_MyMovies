package com.lambdaschool.datapersistencesprintchallenge.db

import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

interface FileManagementInterface {
    fun buildMovieOverviewList(): MutableList<MovieOverview>

    fun createMovieOverview(movieInfo: MovieOverview)

    fun updateMovieOverview(movieInfo: MovieOverview)

    fun deleteMovieOverview(movieInfo: MovieOverview)
}