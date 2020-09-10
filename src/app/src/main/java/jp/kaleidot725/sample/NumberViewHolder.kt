package jp.kaleidot725.sample

import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberViewHolder(val root: FrameLayout) : RecyclerView.ViewHolder(root) {
    // Data
    private lateinit var number : Number

    // View
    private val textView = root.findViewById<TextView>(R.id.simple_text_view)

    fun bind(number : Number) {
        this.number = number
        this.textView.text = number.value
    }

    fun getItemDetails() : NumberDetails = NumberDetails(number)
}
