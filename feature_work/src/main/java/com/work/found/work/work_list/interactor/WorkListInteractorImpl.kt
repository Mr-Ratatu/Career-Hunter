package com.work.found.work.work_list.interactor

import android.content.Context
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.BuildConfig
import javax.inject.Inject

class WorkListInteractorImpl @Inject constructor(
    private val workService: WorkServiceInput,
    private val articlesService: ArticlesServiceInput
) : WorkListInteractorInput {

    override suspend fun fetchWorkList(
        vacanciesName: String,
        callback: (Result<WorkResponse>) -> Unit
    ) {
        try {
            callback(Result.success(workService.fetchWorkList(vacanciesName)))
        } catch (e: Exception) {
            callback(Result.failure(e))
        }
    }

    override suspend fun loadArticles(context: Context, callback: (List<ArticlesItem>) -> Unit) {
        callback(
            articlesService.loadArticles(context, BuildConfig.ARTICLES_ASSET_NAME)
        )
    }
}