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

    fun getAllSeries(): LiveData<List<Series>> {
        return seriesDao.getSeries()
    }

    fun insertSeries(series: Series) {
        seriesDao.insertReminder(series)
    }


    fun deleteAllSeries() {
        seriesDao.deleteAllSeries()
    }
}
