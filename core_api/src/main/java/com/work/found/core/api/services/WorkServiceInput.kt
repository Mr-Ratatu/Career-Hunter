package com.work.found.core.api.services

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import kotlinx.coroutines.flow.Flow

interface WorkServiceInput {

    suspend fun fetchWorkList(vacanciesName: String, page: Int = 0): Result<WorkResponse>

    suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse>
}