package com.example.seriesbacklog.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.seriesbacklog.R
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private lateinit var editViewModel: EditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Add Series"
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
