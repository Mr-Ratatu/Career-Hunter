package com.work.found

import android.app.Application
import com.google.firebase.FirebaseApp
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.di.base.BaseComponent
import com.work.found.core.di.base.ComponentCreator
import com.work.found.core.di.base.DaggerInjector
import com.work.found.di.ApplicationComponent
import com.work.found.routing.base.AppModules

class App : Application(), ComponentCreator {

    private val dependencies by lazy { ApplicationComponent.create(this) }

    override fun onCreate() {
        super.onCreate()

        DaggerInjector.apply {
            initAppComponent(this@App)
            getAppComponent() as ApplicationComponent
        }

        AppModules.initModuleProvider(ModuleProvider())
        AppConfig.init(this)
        FirebaseApp.initializeApp(this)
    }

    override fun create(): BaseComponent {
        return dependencies
    }
}