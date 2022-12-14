package com.work.found.work.articles.interactor

import com.work.found.core.api.model.articles.ArticlesItem

interface ArticlesInteractorInput {
    suspend fun loadArticles(articleId: Int): ArticlesItem?
}