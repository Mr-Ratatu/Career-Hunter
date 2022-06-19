package com.work.found.core.di.dependencies

import com.work.found.core.api.router.ArticlesRouterInput
import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput

interface WorkListDependencies {

    fun workService(): WorkServiceInput

    fun articlesService(): ArticlesServiceInput

    fun workDetailRouter(): WorkDetailRouterInput

    fun articlesRouter(): ArticlesRouterInput
}