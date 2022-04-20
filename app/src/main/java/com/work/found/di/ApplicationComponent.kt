package com.work.found.di

import com.work.found.core.api.di.Dependencies
import com.work.found.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent : Dependencies {

    companion object {
        fun create(): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .build()
        }
    }
}