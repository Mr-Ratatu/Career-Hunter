package com.work.found.work.work_list.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.diffUtilCallback
import com.work.found.core.base.extensions.layoutInflater
import com.work.found.core.base.extensions.setImageFromString
import com.work.found.core.base.presentation.BaseViewHolder
import com.work.found.work.R
import com.work.found.work.articles.api.model.ArticlesItem

class ArticleAdapter(
    private val onClickItem: (id: Int) -> Unit
) : ListAdapter<ArticlesItem, ArticleAdapter.ArticlesViewHolder>(
    diffUtilCallback(
        areContentsTheSame = { oldItem, newItem ->
            oldItem.title == newItem.title
        },
        areItemsTheSame = { oldItem, newItem ->
            oldItem == newItem
        }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(parent.layoutInflater(R.layout.item_article))
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onViewAttachedToWindow(holder: ArticlesViewHolder) {
        val itemPosition = holder.adapterPosition
        holder.itemView.setOnClickListener {
            onClickItem(currentList[itemPosition].id)
        }
    }

    override fun onViewDetachedFromWindow(holder: ArticlesViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    class ArticlesViewHolder(itemView: View) : BaseViewHolder<ArticlesItem>(itemView) {

        private val icon = itemView.contentView<ImageView>(R.id.news_iv_icon)
        private val title = itemView.contentView<TextView>(R.id.news_tv_title)

        override fun bind(item: ArticlesItem) {
            icon { setImageFromString(item.icon) }
            title { text = item.title }
        }
    }
}