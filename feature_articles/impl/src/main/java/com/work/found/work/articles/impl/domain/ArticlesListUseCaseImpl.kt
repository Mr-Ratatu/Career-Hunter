package com.work.found.work.articles.impl.domain

import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.domain.ArticlesListUseCase
import com.work.found.work.articles.api.model.ArticlesItem
import com.work.found.work.articles.impl.BuildConfig

class ArticlesListUseCaseImpl(
    private val articlesService: ArticlesService
): ArticlesListUseCase {
    override fun invoke(): List<ArticlesItem> = articlesService.loadArticles(BuildConfig.ARTICLES_ASSET_NAME)
}