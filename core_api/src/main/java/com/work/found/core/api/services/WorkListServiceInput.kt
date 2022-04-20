package com.work.found.core.api.services

interface WorkListServiceInput {

    suspend fun fetchWorkList(callback: (Unit) -> Unit)
}