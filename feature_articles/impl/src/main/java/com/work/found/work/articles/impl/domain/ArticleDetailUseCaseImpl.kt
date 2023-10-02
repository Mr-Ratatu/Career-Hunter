package com.work.found.work.articles.impl.domain

import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.domain.ArticleDetailUseCase
import com.work.found.work.articles.api.model.ArticlesItem
import com.work.found.work.articles.impl.BuildConfig
import javax.inject.Inject

class ArticleDetailUseCaseImpl @Inject constructor(
    private val service: ArticlesService
): ArticleDetailUseCase {

    override operator fun invoke(articleId: Int): ArticlesItem? {
        return service
            .loadArticles(BuildConfig.ARTICLES_ASSET_NAME)
            .find { item -> item.id == articleId }
    }
}