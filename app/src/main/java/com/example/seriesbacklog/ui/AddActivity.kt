package com.example.seriesbacklog.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.seriesbacklog.R
import com.example.seriesbacklog.model.Series
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*

const val EXTRA_SERIES = "EXTRA_SERIES"

class AddActivity : AppCompatActivity() {

    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Add Series"
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        if (seriesTitle.text.toString().isNotBlank() &&
            seriesPlatform.text.toString().isNotBlank() &&
            seriesDay.text.toString().isNotBlank() &&
            seriesMonth.text.toString().isNotBlank() &&
            seriesYear.text.toString().isNotBlank()) {

            val series = Series(seriesTitle.text.toString(), seriesPlatform.text.toString(), seriesDay.text.toString(), seriesMonth.text.toString(), seriesYear.text.toString() )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_SERIES, series)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"Fill in all the fields"
                , Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_NOTE = "EXTRA_NOTE"
    }
}
