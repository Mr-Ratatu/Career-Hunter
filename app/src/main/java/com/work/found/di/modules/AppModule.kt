package com.work.found.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        ServiceModule::class,
        InteractorModule::class,
        UtilsModule::class,
        CoroutineScopeModule::class,
    ]
)
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application
}