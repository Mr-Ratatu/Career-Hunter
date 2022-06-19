package com.work.found.work.articles.interactor

import android.content.Context
import com.work.found.core.api.model.articles.ArticlesItem

interface ArticlesInteractorInput {
    suspend fun loadArticles(context: Context, id: Int): ArticlesItem?
}