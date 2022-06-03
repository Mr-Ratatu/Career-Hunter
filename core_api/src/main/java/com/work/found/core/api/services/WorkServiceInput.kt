package com.work.found.core.api.services

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkResponse

interface WorkServiceInput {

    suspend fun fetchWorkList(vacanciesName: String): WorkResponse

    suspend fun fetchWorkDetail(id: String): WorkDetailResponse
}