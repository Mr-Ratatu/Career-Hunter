package com.work.found.core.base.extensions

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.initRecyclerView(
    adapter: RecyclerView.Adapter<*>,
    fixedSize: Boolean = false
) {
    setHasFixedSize(fixedSize)
    this.adapter = adapter
}

fun RecyclerView.verticalLinearLayoutManager() = LinearLayoutManager(context)

fun RecyclerView.horizontalLinearLayoutManager() =
    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

fun Context.gridLayoutManager(spanCount: Int) = GridLayoutManager(this, spanCount)

/**
 * Create an ItemCallback callback instance
 */
inline fun <T> diffUtilCallback(
    crossinline areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
    crossinline areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
) = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areContentsTheSame(oldItem, newItem)
    }
}