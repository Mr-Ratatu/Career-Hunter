package com.work.found.work.articles.interactor

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.work.BuildConfig
import javax.inject.Inject

class ArticlesInteractorImpl @Inject constructor(
    private val service: ArticlesServiceInput
) : ArticlesInteractorInput {

    override suspend fun loadArticles(articleId: Int): ArticlesItem? {
        return service
            .loadArticles(BuildConfig.ARTICLES_ASSET_NAME)
            .find { item -> item.id == articleId }
    }
}