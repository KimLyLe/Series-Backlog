package com.example.seriesbacklog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.seriesbacklog.db.SeriesRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val seriesRepository = SeriesRepository(application.applicationContext)

    val series = seriesRepository.getAllSeries()

}
