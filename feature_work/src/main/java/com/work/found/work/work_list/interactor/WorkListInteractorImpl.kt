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

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return try {
            Result.success(workService.fetchWorkList(vacanciesName))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun loadArticles(context: Context): List<ArticlesItem> {
        return articlesService.loadArticles(context, BuildConfig.ARTICLES_ASSET_NAME)
    }
}