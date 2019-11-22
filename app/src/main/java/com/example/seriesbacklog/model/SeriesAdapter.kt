package com.example.seriesbacklog.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SeriesAdapter (private val series: List<Series>) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return series.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(series[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val seriesTitle: TextView = itemView.findViewById(android.R.id.text1)
        private val seriesPlatform: TextView = itemView.findViewById(android.R.id.text1)
        private val seriesDay: TextView = itemView.findViewById(android.R.id.text1)
        private val seriesMonth: TextView = itemView.findViewById(android.R.id.text1)
        private val seriesYear: TextView = itemView.findViewById(android.R.id.text1)


        fun bind(series: Series) {
            seriesTitle.text = series.title
            seriesPlatform.text = series.platform
            seriesDay.text = series.day
            seriesMonth.text = series.month
            seriesYear.text = series.year
        }
    }
}