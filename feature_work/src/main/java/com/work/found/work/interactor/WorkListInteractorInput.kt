package com.work.found.work.interactor

import com.work.found.core.api.model.work.WorkResponse

interface WorkListInteractorInput {

    suspend fun fetchWorkList(
        vacanciesName: String,
        callback: (Result<WorkResponse>) -> Unit
    )
}