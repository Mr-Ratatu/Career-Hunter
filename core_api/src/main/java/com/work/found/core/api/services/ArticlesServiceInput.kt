package com.work.found.core.api.services

import android.content.Context
import com.work.found.core.api.model.articles.ArticlesItem

interface ArticlesServiceInput {

    fun loadArticles(context: Context, articlesAssetName: String): List<ArticlesItem>
}