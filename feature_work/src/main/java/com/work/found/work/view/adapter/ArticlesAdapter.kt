package com.work.found.work.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.work.found.core.api.model.news.ArticlesItem
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.diffUtilCallback
import com.work.found.core.base.extensions.layoutInflater
import com.work.found.core.base.presentation.BaseViewHolder
import com.work.found.work.R

class ArticlesAdapter(
    private val onClickItem: (id: Int) -> Unit
) : ListAdapter<ArticlesItem, ArticlesAdapter.ArticlesViewHolder>(
    diffUtilCallback(
        areContentsTheSame = { oldItem, newItem ->
            oldItem == newItem
        },
        areItemsTheSame = { oldItem, newItem ->
            oldItem.title == newItem.title
        }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(parent.layoutInflater(R.layout.item_articles))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ArticlesViewHolder(itemView: View) : BaseViewHolder<ArticlesItem>(itemView) {

        private val icon = itemView.contentView<ImageView>(R.id.news_iv_icon)
        private val title = itemView.contentView<TextView>(R.id.news_tv_title)

        override fun bind(item: ArticlesItem) {
            icon { setImageResource(item.icon) }
            title { text = item.title }
        }
    }
}