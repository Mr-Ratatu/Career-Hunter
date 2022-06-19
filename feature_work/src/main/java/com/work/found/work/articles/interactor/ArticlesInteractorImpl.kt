package com.work.found.work.articles.interactor

import android.content.Context
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.work.BuildConfig
import javax.inject.Inject

class ArticlesInteractorImpl @Inject constructor(
    private val service: ArticlesServiceInput
) : ArticlesInteractorInput {

    override suspend fun loadArticles(context: Context, id: Int): ArticlesItem? {
        return service.loadArticles(
            context, BuildConfig.ARTICLES_ASSET_NAME
        ).find { item ->
            item.id == id
        }
    }
}