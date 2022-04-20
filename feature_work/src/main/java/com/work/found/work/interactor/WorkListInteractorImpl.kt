package com.work.found.work.interactor

import com.work.found.core.api.services.WorkListServiceInput
import javax.inject.Inject

class WorkListInteractorImpl @Inject constructor(
    private val workService: WorkListServiceInput
) : WorkListInteractorInput {

    override suspend fun fetchWorkList(callback: (Unit) -> Unit) {
        workService.fetchWorkList(callback)
    }
}