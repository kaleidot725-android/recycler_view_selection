package jp.kaleidot725.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter() : RecyclerView.Adapter<NumberViewHolder>() {
    var data : List<Number> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.simple_item, parent, false) as FrameLayout
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun getItem(position: Int) = data[position]

    fun getPosition(number: Number) = data.indexOf(number)
}
