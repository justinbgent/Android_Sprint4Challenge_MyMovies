package com.lambdaschool.datapersistencesprintchallenge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lambdaschool.datapersistencesprintchallenge.dao.MovieDao
import com.lambdaschool.sprint4challenge_mymovies.model.MovieOverview

@Database(entities = [MovieOverview::class], version = 2, exportSchema = false)
abstract class MovieDB: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}