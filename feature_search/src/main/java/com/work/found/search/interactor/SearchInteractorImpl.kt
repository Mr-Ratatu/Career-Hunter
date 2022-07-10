package com.work.found.search.interactor

import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.services.WorkServiceInput
import javax.inject.Inject

class SearchInteractorImpl @Inject constructor(
    private val workService: WorkServiceInput
) : SearchInteractorInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return try {
            Result.success(workService.fetchWorkList(vacanciesName))
        } catch (error: Throwable) {
            Result.failure(error)
        }
    }
}