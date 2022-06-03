package com.work.found.work.detail.interactor

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.services.WorkServiceInput
import javax.inject.Inject

class WorkDetailInteractorImpl @Inject constructor(
    private val workService: WorkServiceInput
) : WorkDetailInteractorInput {

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        return try {
            Result.success(workService.fetchWorkDetail(id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}