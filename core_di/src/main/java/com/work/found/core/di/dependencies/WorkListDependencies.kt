package com.work.found.core.di.dependencies

import com.work.found.core.api.services.WorkListServiceInput

interface WorkListDependencies {

    fun workListService(): WorkListServiceInput
}