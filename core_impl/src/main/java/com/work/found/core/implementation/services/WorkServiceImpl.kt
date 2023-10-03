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

    override suspend fun fetchWorkList(vacanciesName: String, page: Int): Result<WorkResponse> {
        val url = HttpUrl.Builder()
            .setSegment(VACANCIES_SEGMENT_KEY)
            .setQuery(WORK_NAME_QUERY_KEY, vacanciesName)
            .setQuery(PAGE_QUERY_KEY, page)
            .build()

        return wrapper.wrapWithResult { apiProvider.execute(WorkResponse::class.java, url) }
    }

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        val url = HttpUrl.Builder()
            .setSegment(VACANCIES_SEGMENT_KEY)
            .setSegment(id)
            .build()

        return wrapper.wrapWithResult {
            apiProvider.execute(WorkDetailResponse::class.java, url)
        }
    }

    companion object {
        private const val VACANCIES_SEGMENT_KEY = "vacancies"
        private const val WORK_NAME_QUERY_KEY = "text"
        private const val PAGE_QUERY_KEY = "page"
    }
}