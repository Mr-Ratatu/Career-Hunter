package com.work.found.mock

import com.work.found.ExpensesFactory
import com.work.found.core.api.model.detail.*
import com.work.found.core.api.model.work.Area
import com.work.found.core.api.model.work.Employer
import com.work.found.core.api.model.work.Salary
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import java.net.UnknownHostException

internal class MockWorkService(
    private val returnSuccess: Boolean = false,
    private val returnError: Boolean = false
) : WorkServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return when {
            returnSuccess -> Result.Success(ExpensesFactory.workResponse)
            returnError -> Result.Error
            else -> Result.Loading
        }
    }

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        return when {
            returnSuccess -> Result.Success(ExpensesFactory.workDetailResponse)
            returnError -> Result.Error
            else -> Result.Loading
        }
    }
}