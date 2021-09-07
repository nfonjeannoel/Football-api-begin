package com.example.android.marsrealestate.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.Responses
import com.example.android.marsrealestate.network.Teams


class PhotoGridAdapter(val listener: MatchClickListener) : ListAdapter<Responses, PhotoGridAdapter.ViewHolder>(DiffCallback){
    class ViewHolder(val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun from(liveGame: Responses?) {
            binding.tvHomeName.text = liveGame?.teams?.home?.name
            binding.tvAwayName.text = liveGame?.teams?.away?.name
            binding.tvHomeGoal.text = liveGame?.goals?.home.toString()
            binding.tvAwayGoal.text = liveGame?.goals?.away.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridViewItemBinding.inflate(inflater)
        return ViewHolder(binding)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var liveGame = getItem(position)
        holder.from(liveGame)
        holder.itemView.setOnClickListener {
            listener.onClick(liveGame)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Responses>() {
        override fun areItemsTheSame(oldItem: Responses, newItem: Responses): Boolean {
            return oldItem.fixture?.id == newItem.fixture?.id
        }

        override fun areContentsTheSame(oldItem: Responses, newItem: Responses): Boolean {
            return oldItem == newItem
        }
    }
}











