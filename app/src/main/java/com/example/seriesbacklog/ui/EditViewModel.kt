package com.example.seriesbacklog.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.seriesbacklog.db.SeriesRepository
import com.example.seriesbacklog.model.Series
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditViewModel(application: Application) : AndroidViewModel(application) {

    private val seriesRepository = SeriesRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val series = MutableLiveData<Series?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()

    fun updateSeries() {
        if (isNoteValid()) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    seriesRepository.updateSeries(series.value!!)
                }
                success.value = true
            }
        }
    }

    private fun isNoteValid(): Boolean {
        return when {
            series.value == null -> {
                error.value = "Fill in a series!"
                false
            }
            series.value!!.title.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }

            series.value!!.platform.isBlank() -> {
                error.value = "Platform must not be empty"
                false
            }

            series.value!!.month.isBlank() -> {
                error.value = "Month must not be empty"
                false
            }

            series.value!!.year.isBlank() -> {
                error.value = "Year must not be empty"
                false
            }
            else -> true
        }
    }
}