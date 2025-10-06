package com.interview.skeleton.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.interview.skeleton.R
import com.interview.skeleton.domain.model.Data

class ListAdapter(
    private val onDataClick: (Data) -> Unit
) : RecyclerView.Adapter<ListAdapter.DataViewHolder>() {

    private val data = mutableListOf<Data>()

    fun submitList(newData: List<Data>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvDataName)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.tvDataDescription)

        fun bind(data: Data) {
            nameTextView.text = data.name
            priceTextView.text = data.price.toString()

            itemView.setOnClickListener {
                onProductClick(product)
            }
        }
    }
}
