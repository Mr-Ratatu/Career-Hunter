package com.work.found.core.implementation.network

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.network_service.ApiProvider
import com.work.found.core.api.network_service.HttpUrl
import com.work.found.core.api.network_service.WorksNetworkDataSource

class WorksNetworkDataSourceImpl(
    private val apiProvider: ApiProvider,
): WorksNetworkDataSource {
    override suspend fun fetchWorkList(vacanciesName: String, page: Int): WorkResponse {
        val url = HttpUrl.Builder()
            .setSegment(VACANCIES_SEGMENT_KEY)
            .setQuery(WORK_NAME_QUERY_KEY, vacanciesName)
            .setQuery(PAGE_QUERY_KEY, page)
            .build()

        return apiProvider.execute(WorkResponse::class.java, url)
    }

    override suspend fun fetchWorkDetail(id: String): WorkDetailResponse {
        val url = HttpUrl.Builder()
            .setSegment(VACANCIES_SEGMENT_KEY)
            .setSegment(id)
            .build()

        return apiProvider.execute(WorkDetailResponse::class.java, url)
    }


    companion object {
        private const val VACANCIES_SEGMENT_KEY = "vacancies"
        private const val WORK_NAME_QUERY_KEY = "text"
        private const val PAGE_QUERY_KEY = "page"
    }
}