package com.work.found.di.modules

import android.content.Context
import com.work.found.core.api.managers.NetworkConnectionManager
import com.work.found.core.api.wrapers.ResultWrapper
import com.work.found.core.implementation.wrapers.NetworkResultWrapper
import com.work.found.managers.NetworkConnectionManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Provides
    @Singleton
    fun provideResultWrapper(): ResultWrapper {
        return NetworkResultWrapper()
    }

    @Provides
    @Singleton
    fun provideNetworkConnectionManager(context: Context) : NetworkConnectionManager {
        return NetworkConnectionManagerImpl(context)
    }
}