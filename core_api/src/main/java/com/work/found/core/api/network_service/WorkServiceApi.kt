package com.work.found.core.api.network_service

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.model.work.WorkDto
import com.work.found.core.api.model.work.WorkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorkServiceApi {

    @GET("vacancies")
    suspend fun fetchWorkList(@Query("text") vacanciesName: String): WorkResponse

    @GET("vacancies/{id}")
    suspend fun fetchWorkDetail(@Path("id") id: String): WorkDetailResponse
}