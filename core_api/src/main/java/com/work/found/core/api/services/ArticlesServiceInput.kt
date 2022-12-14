package com.work.found.core.api.services

import com.work.found.core.api.model.articles.ArticlesItem

interface ArticlesServiceInput {

    fun loadArticles(articlesAssetName: String): List<ArticlesItem>
}