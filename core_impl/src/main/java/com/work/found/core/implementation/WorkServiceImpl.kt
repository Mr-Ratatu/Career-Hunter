package com.work.found.core.implementation

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.network_service.WorkServiceApi
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.core.api.wrapers.ResultWrapper
import javax.inject.Inject

class WorkServiceImpl @Inject constructor(
    private val api: WorkServiceApi,
    private val wrapper: ResultWrapper
) : WorkServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return wrapper.wrapWithResult {
            api.fetchWorkList(vacanciesName)
        }
    }

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        return wrapper.wrapWithResult {
            api.fetchWorkDetail(id)
        }
    }
}