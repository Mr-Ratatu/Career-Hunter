package com.work.found.work.detail.interactor

import com.work.found.core.api.model.detail.WorkDetailResponse

interface WorkDetailInteractorInput {

    suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse>
}