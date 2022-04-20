package com.work.found.core.api.di.dependencies

import com.work.found.core.api.router.WorkListRouterInput

interface SplashDependencies {

    fun workListRouter(): WorkListRouterInput
}