package com.example.seriesbacklog.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.seriesbacklog.R
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*

class AddActivity : AppCompatActivity() {

    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Add Series"

        initViews()
        initViewModel()
    }

    private fun initViews() {
        fab.setOnClickListener {
            editViewModel.series.value?.apply {
                title = seriesTitle.text.toString()
                platform = seriesPlatform.text.toString()
                day = seriesDay.text.toString()
                month = seriesMonth.text.toString()
                year = seriesYear.text.toString()

            }
            editViewModel.updateSeries()
        }
    }

    private fun initViewModel() {
        editViewModel = ViewModelProviders.of(this).get(EditViewModel::class.java)
        editViewModel.series.value = intent.extras?.getParcelable(EXTRA_NOTE)!!

        editViewModel.series.observe(this, Observer { series ->
            if (series != null) {
                seriesTitle.setText(series.title)
                seriesPlatform.setText(series.platform)
                seriesDay.setText(series.day)
                seriesMonth.setText(series.month)
                seriesYear.setText(series.year)
            }
        })

        editViewModel.error.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        editViewModel.success.observe(this, Observer { success ->
            if (success) finish()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> { // Used to identify when the user has clicked the back button
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }
}
