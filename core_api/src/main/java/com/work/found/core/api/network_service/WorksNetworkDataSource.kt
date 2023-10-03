package com.work.found.core.api.network_service

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse

interface WorksNetworkDataSource {
    suspend fun fetchWorkList(vacanciesName: String, page: Int): WorkResponse
    suspend fun fetchWorkDetail(id: String): WorkDetailResponse
}