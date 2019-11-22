package com.example.seriesbacklog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.seriesbacklog.db.SeriesRepository
import com.example.seriesbacklog.model.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val seriesRepository = SeriesRepository(application.applicationContext)

    val series: LiveData<List<Series>> = seriesRepository.getAllSeries()

    fun insertSeries(series: Series) {
        ioScope.launch {
            seriesRepository.insertSeries(series)
        }
    }

    fun deleteReminder(series: Series) {
        ioScope.launch {
            seriesRepository.deleteSeries(series)
        }
    }


}
