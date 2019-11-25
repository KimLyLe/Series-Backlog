package com.example.seriesbacklog.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.seriesbacklog.model.Series

@Dao
interface SeriesDao {
    @Insert
    suspend fun insertSeries(series: Series)

    @Query("SELECT * FROM seriesTable ORDER BY date ")
    fun getSeries(): LiveData<List<Series>>

    @Insert
    fun insertReminder(series: Series)

    @Delete
    fun deleteSeries(series: Series)

    @Update
    suspend fun updateSeries(series: Series)
}