package com.work.found.search.interactor

import com.work.found.core.api.model.work.WorkResponse

interface SearchInteractorInput {

    suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse>
}