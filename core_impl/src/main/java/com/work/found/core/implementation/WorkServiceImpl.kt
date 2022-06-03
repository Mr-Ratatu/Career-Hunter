package com.work.found.core.implementation

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.network_service.WorkServiceApi
import com.work.found.core.api.services.WorkServiceInput
import javax.inject.Inject

class WorkServiceImpl @Inject constructor(
    private val api: WorkServiceApi
) : WorkServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): WorkResponse {
        return api.fetchWorkList(vacanciesName)
    }

    override suspend fun fetchWorkDetail(id: String): WorkDetailResponse {
        return api.fetchWorkDetail(id)
    }
}