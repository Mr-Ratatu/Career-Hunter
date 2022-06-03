package com.work.found.core.di.dependencies

import com.work.found.core.api.services.WorkServiceInput

interface WorkDerailDependencies {

    fun workService(): WorkServiceInput
}