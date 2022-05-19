package com.work.found.core.implementation

import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.network_service.WorkServiceApi
import com.work.found.core.api.services.WorkListServiceInput
import javax.inject.Inject

class WorkListServiceImpl @Inject constructor(
    private val api: WorkServiceApi
) : WorkListServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): WorkResponse {
        return api.fetchWorkList(vacanciesName)
    }
}