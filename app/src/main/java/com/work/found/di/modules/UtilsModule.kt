package com.work.found.di.modules

import com.work.found.annotations.AndroidMainAnnotation
import com.work.found.core.api.managers.NetworkConnectionManager
import com.work.found.core.api.wrapers.ResultWrapper
import com.work.found.core.implementation.wrapers.NetworkResultWrapper
import com.work.found.managers.NetworkConnectionManagerImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
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
    fun provideNetworkConnectionManager(
        @AndroidMainAnnotation coroutineScope: CoroutineScope
    ) : NetworkConnectionManager {
        return NetworkConnectionManagerImpl(coroutineScope)
    }
}