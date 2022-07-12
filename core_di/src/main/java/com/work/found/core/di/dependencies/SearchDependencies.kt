package com.work.found.core.di.dependencies

import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.api.services.WorkServiceInput

interface SearchDependencies {

    fun workService(): WorkServiceInput

    fun workDetailsRouter(): WorkDetailRouterInput
}