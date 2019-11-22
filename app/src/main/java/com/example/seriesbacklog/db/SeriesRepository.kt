package com.example.seriesbacklog.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.seriesbacklog.model.Series

class SeriesRepository(context: Context) {

    private val seriesDao: SeriesDao

    init {
        val reminderRoomDatabase = SeriesRoomDatabase.getDatabase(context)
        seriesDao = reminderRoomDatabase!!.seriesDao()
    }

    fun getAllSeries(): LiveData<Series?> {
        return seriesDao.getSeries()
    }


    fun deleteSeries(series: Series) {
        seriesDao.deleteSeries(series)
    }

    suspend fun updateSeries(series: Series) {
        seriesDao.updateSeries(series)
    }

}
