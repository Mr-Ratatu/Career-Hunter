package com.work.found.core.di.dependencies

import com.work.found.core.api.router.HomeRouterInput
import com.work.found.core.api.router.SplashRouterInput

interface RootDependencies {

    fun splashRouter(): SplashRouterInput

    fun homeRouter(): HomeRouterInput
}