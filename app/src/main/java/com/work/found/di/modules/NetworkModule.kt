package com.work.found.di.modules

import com.google.gson.Gson
import com.work.found.BuildConfig
import com.work.found.core.api.network_service.ApiProvider
import com.work.found.core.implementation.network.ApiProviderImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                }
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideApiProvider(client: OkHttpClient, gson: Gson): ApiProvider {
        return ApiProviderImpl(client, gson)
    }

    @Provides
    @Singleton
    fun provideGson() = Gson()
}