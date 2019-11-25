package com.example.seriesbacklog.model
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.series_item.view.*
import android.R.attr.data
import android.content.Context
import android.provider.Settings.Global.getString
import androidx.core.content.ContextCompat
import com.example.seriesbacklog.R


class SeriesAdapter (private val series: List<Series>) :
    RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    lateinit var context: Context

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.series_item, parent, false)
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

        fun bind(series: Series) {
            itemView.tvTitle.text = series.title
            itemView.tvPlatform.text = series.platform
            itemView.tvDate.text = String.format(context.getString(R.string.tvDate), series.date.toString())
        }
    }
}