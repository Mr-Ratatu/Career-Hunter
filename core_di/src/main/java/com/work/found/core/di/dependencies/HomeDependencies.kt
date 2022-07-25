package com.work.found.core.di.dependencies

import com.work.found.core.api.router.WorkListRouterInput

interface HomeDependencies {

    fun workListRouter(): WorkListRouterInput
}