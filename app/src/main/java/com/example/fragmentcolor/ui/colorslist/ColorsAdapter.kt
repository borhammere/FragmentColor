package com.example.fragmentcolor.ui.colorslist

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentcolor.domain.ColorEntity

class ColorsAdapter(
    private val itemClickCallback: (ColorEntity) -> Unit
) : RecyclerView.Adapter<ColorViewHolder>() {

    var data: List<ColorEntity> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ColorViewHolder.createView(parent)

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(getItem(position), itemClickCallback)
    }

    private fun getItem(pos: Int) = data[pos]

    override fun getItemCount() = data.size

}
