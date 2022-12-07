package com.work.found.di

import android.app.Application
import com.work.found.core.di.Dependencies
import com.work.found.core.di.base.BaseComponent
import com.work.found.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent : BaseComponent, Dependencies {

    companion object {
        fun create(application: Application): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .appModule(AppModule(application))
                .build()
        }
    }
}