package com.work.found.work.work_list.domain

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.work.BuildConfig

class WorkListInteractorImpl constructor(
    private val workService: WorkServiceInput,
    private val articlesService: ArticlesServiceInput
) : WorkListInteractorInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return workService.fetchWorkList(vacanciesName)
    }

    override suspend fun loadArticles(): List<ArticlesItem> {
        return articlesService.loadArticles(BuildConfig.ARTICLES_ASSET_NAME)
    }
}