package com.example.fragmentcolor.ui.colorslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentcolor.domain.ColorEntity
import com.example.fragmentcolor.R
import com.example.fragmentcolor.databinding.ItemColorBinding


class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemColorBinding.bind(itemView)

    companion object {
        @JvmStatic
        fun createView(parent: ViewGroup): ColorViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
            return ColorViewHolder(view)
        }
    }

    fun bind(item: ColorEntity, listener: (ColorEntity) -> Unit) {
        binding.colorNameTextView.text = item.name
        binding.root.setBackgroundColor(item.color)
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }
}