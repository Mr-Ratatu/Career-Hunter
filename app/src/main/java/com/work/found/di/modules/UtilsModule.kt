package com.work.found.di.modules

import com.work.found.core.api.wrapers.ResultWrapper
import com.work.found.core.implementation.wrapers.NetworkResultWrapper
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun provideResultWrapper(): ResultWrapper {
        return NetworkResultWrapper()
    }
}