package com.work.found.di.modules

import com.work.found.annotations.AndroidDefaultAnnotation
import com.work.found.annotations.AndroidIOAnnotation
import com.work.found.annotations.AndroidMainAnnotation
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@Module
class CoroutineScopeModule {

    @Provides
    @AndroidDefaultAnnotation
    fun provideDefaultCoroutineScope() =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    @AndroidMainAnnotation
    fun provideMainCoroutineScope() =
        CoroutineScope(SupervisorJob() + Dispatchers.Main)

    @Provides
    @AndroidIOAnnotation
    fun provideDIOCoroutineScope() =
        CoroutineScope(SupervisorJob() + Dispatchers.IO)
}