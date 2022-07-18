package com.work.found.work.detail.interactor

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.services.WorkServiceInput
import javax.inject.Inject
import com.work.found.core.api.state.Result

class WorkDetailInteractorImpl @Inject constructor(
    private val workService: WorkServiceInput
) : WorkDetailInteractorInput {

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        return workService.fetchWorkDetail(id)
    }
}