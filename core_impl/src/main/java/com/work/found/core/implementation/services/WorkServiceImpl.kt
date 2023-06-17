package com.work.found.core.implementation.services

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.network_service.ApiProvider
import com.work.found.core.api.network_service.HttpUrl
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.core.api.wrapers.ResultWrapper
import javax.inject.Inject

class WorkServiceImpl @Inject constructor(
    private val wrapper: ResultWrapper,
    private val apiProvider: ApiProvider,
) : WorkServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        val url = HttpUrl.Builder()
            .setSegment("vacancies")
            .setQuery("text", vacanciesName)
            .build()

        return wrapper.wrapWithResult { apiProvider.execute(WorkResponse::class.java, url) }
    }

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        val url = HttpUrl.Builder()
            .setSegment("vacancies")
            .setSegment(id)
            .build()

        return wrapper.wrapWithResult {
            apiProvider.execute(WorkDetailResponse::class.java, url)
        }
    }
}