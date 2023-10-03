package com.work.found.work.work_list.view.adapter

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.layoutInflater
import com.work.found.work.R
import com.work.found.work.articles.api.model.ArticlesItem

class ArticlesListAdapter(
    private val itemOnClick: (id: Int) -> Unit
) : RecyclerView.Adapter<ArticlesListAdapter.ArticlesListHolder>() {

    companion object {
        private const val ARTICLES_HEADER_COUNT = 1
    }

    private val articles = mutableListOf<ArticlesItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setArticles(list: List<ArticlesItem>) {
        articles.clear()
        articles.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesListHolder {
        return ArticlesListHolder(
            parent.layoutInflater(R.layout.item_articles_list),
            itemOnClick
        )
    }

    override fun onBindViewHolder(holder: ArticlesListHolder, position: Int) {
        holder.bind(articles)
    }

    override fun getItemCount(): Int = ARTICLES_HEADER_COUNT

    class ArticlesListHolder(
        itemView: View,
        itemOnClick: (id: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val articlesList = itemView.contentView<RecyclerView>(R.id.work_rv_articles_list)
        private val articleAdapter = ArticleAdapter(itemOnClick)

        fun bind(item: List<ArticlesItem>) {
            articlesList {
                adapter = articleAdapter
            }
            articleAdapter.submitList(item)
        }
    }
}