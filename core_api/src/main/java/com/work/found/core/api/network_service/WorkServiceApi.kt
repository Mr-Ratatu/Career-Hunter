package com.work.found.core.api.network_service

import retrofit2.http.GET

interface WorkServiceApi {

    @GET
    fun fetchWorkList()
}