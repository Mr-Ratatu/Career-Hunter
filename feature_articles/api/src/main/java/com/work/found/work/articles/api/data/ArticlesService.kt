package com.work.found.work.articles.api.data

import com.work.found.work.articles.api.model.ArticlesItem

interface ArticlesService {
    fun loadArticles(articlesAssetName: String): List<ArticlesItem>
}