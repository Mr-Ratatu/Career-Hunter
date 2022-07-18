package com.work.found.mock

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
    private val returnError: Boolean = false,
    private val unknownHostException: UnknownHostException
) : WorkServiceInput {

    override suspend fun fetchWorkList(vacanciesName: String): Result<WorkResponse> {
        return when {
            returnSuccess -> Result.Success(workResponse)
            returnError -> Result.Error(unknownHostException)
            else -> Result.Loading
        }
    }

    override suspend fun fetchWorkDetail(id: String): Result<WorkDetailResponse> {
        return when {
            returnSuccess -> Result.Success(workDetailResponse)
            returnError -> Result.Error(unknownHostException)
            else -> Result.Loading
        }
    }

    companion object {
        val workResponse = WorkResponse(
            alternate_url = "",
            found = 10,
            items = emptyList(),
            pages = 5,
            page = 2,
            per_page = 3
        )

        val workDetailResponse = WorkDetailResponse(
            address = "",
            area = Area(),
            contacts = "",
            description = "",
            employer = Employer(),
            employment = Employment(),
            experience = Experience(),
            id = "67495966",
            key_skills = emptyList(),
            name = "Android-разработчик",
            salary = Salary(),
            schedule = Schedule(),
            site = Site(),
        )
    }
}