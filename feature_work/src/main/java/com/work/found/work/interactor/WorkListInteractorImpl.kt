package com.work.found.work.interactor

import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.services.WorkListServiceInput
import java.net.SocketTimeoutException
import javax.inject.Inject

class WorkListInteractorImpl @Inject constructor(
    private val workService: WorkListServiceInput
) : WorkListInteractorInput {

    override suspend fun fetchWorkList(
        vacanciesName: String,
        callback: (Result<WorkResponse>) -> Unit
    ) {
        try {
            callback(Result.success(workService.fetchWorkList(vacanciesName)))
        } catch (e: Exception) {
            callback(Result.failure(e))
        }
    }
}