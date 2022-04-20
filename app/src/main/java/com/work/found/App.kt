package com.work.found

import android.app.Application
import com.work.found.core.api.di.AppWithFacade
import com.work.found.core.api.di.Dependencies
import com.work.found.di.ApplicationComponent

class App : Application(), AppWithFacade {

    private val dependencies by lazy { ApplicationComponent.create() }

    override fun getAppFacade(): Dependencies {
        return dependencies
    }
}