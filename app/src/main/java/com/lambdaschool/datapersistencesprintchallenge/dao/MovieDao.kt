package com.lambdaschool.datapersistencesprintchallenge.dao

import androidx.room.*
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieOverview")
    fun buildMovieOverviewList(): MutableList<MovieOverview>

    @Insert
    fun createMovieOverview(movieInfo: MovieOverview)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovieOverview(movieInfo: MovieOverview)

    @Delete
    fun deleteMovieOverview(movieInfo: MovieOverview)
}