package com.work.found.core.implementation.network

import com.google.gson.Gson
import com.work.found.core.api.network_service.ApiProvider
import com.work.found.core.api.network_service.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class ApiProviderImpl(private val client: OkHttpClient, private val gson: Gson) : ApiProvider {

    override suspend fun <T> execute(clazz: Class<T>, httpUrl: HttpUrl): T =
        suspendCoroutine { continuation ->
            client.newCall(getRequest(httpUrl)).execute().use {
                when (it.isSuccessful) {
                    true -> continuation.resumeWith(Result.success(it.deserialize(clazz)))
                    false -> continuation.resumeWithException(Throwable(it.message))
                }
            }
        }

    private fun getRequest(httpUrl: HttpUrl): Request {
        val url = okhttp3.HttpUrl.Builder()
            .scheme(httpUrl.scheme.name)
            .host(httpUrl.host)
            .apply { httpUrl.segment.forEach(::addPathSegment) }
            .apply { httpUrl.query.forEach { addQueryParameter(it.key, it.value) } }
            .apply { httpUrl.path.forEach { addEncodedQueryParameter(it.key, it.value) } }
            .build()

        return Request.Builder().url(url).build()
    }

    private fun <T> Response.deserialize(clazz: Class<T>): T {
        return gson.fromJson(this.body?.string(), clazz)
    }
}