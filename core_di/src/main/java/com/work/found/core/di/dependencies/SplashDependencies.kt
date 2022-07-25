package com.work.found.core.di.dependencies

import com.work.found.core.api.router.HomeRouterInput
import com.work.found.core.api.router.WorkListRouterInput

interface SplashDependencies {

    fun workListRouter(): WorkListRouterInput

    fun homeRouter(): HomeRouterInput
}