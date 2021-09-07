package com.example.android.marsrealestate.overview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.network.Teams


class PhotoGridAdapter : ListAdapter<Teams, PhotoGridAdapter.ViewHolder>(DiffCallback){
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Teams>() {
        override fun areItemsTheSame(oldItem: Teams, newItem: Teams): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Teams, newItem: Teams): Boolean {
            TODO("Not yet implemented")
        }
    }
}











