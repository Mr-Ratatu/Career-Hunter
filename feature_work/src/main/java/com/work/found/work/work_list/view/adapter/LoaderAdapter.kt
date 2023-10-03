package com.work.found.work.work_list.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.work.found.work.R
import com.work.found.work.databinding.ItemLoaderBinding

class LoaderAdapter : LoadStateAdapter<LoaderAdapter.LoaderViewHolder>() {

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoaderViewHolder {
        return LoaderViewHolder.create(parent)
    }

    class LoaderViewHolder(
        private val binding: ItemLoaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(state: LoadState) {
            binding.workListLoader.isVisible = state is LoadState.Loading
            binding.workListErrorRetry.isVisible = state is LoadState.Error
        }

        companion object {
            fun create(viewGroup: ViewGroup): LoaderViewHolder {
                val inflater = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_loader, viewGroup, false)
                val binding = ItemLoaderBinding.bind(inflater)
                return LoaderViewHolder(binding)
            }
        }
    }
}