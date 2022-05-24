package com.work.found.core.api.services

import com.work.found.core.api.model.work.WorkResponse

interface WorkListServiceInput {

    suspend fun fetchWorkList(vacanciesName: String): WorkResponse
}