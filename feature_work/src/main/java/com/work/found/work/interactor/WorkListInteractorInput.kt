package com.work.found.work.interactor

import android.content.Context
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse

interface WorkListInteractorInput {

    suspend fun fetchWorkList(
        vacanciesName: String,
        callback: (Result<WorkResponse>) -> Unit
    )

    suspend fun loadArticles(context: Context): List<ArticlesItem>
}