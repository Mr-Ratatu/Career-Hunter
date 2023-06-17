package com.work.found.core.api.network_service

interface ApiProvider {
    suspend fun <T> execute(clazz: Class<T>, httpUrl: HttpUrl): T
}