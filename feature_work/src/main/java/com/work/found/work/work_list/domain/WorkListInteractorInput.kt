package com.work.found.work.work_list.domain

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result

interface WorkListInteractorInput {

    suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse>

    suspend fun loadArticles(): List<ArticlesItem>
}