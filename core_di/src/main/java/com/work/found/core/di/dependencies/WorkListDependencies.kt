package com.work.found.core.di.dependencies

import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput

interface WorkListDependencies {

    fun workService(): WorkServiceInput

    fun articlesService(): ArticlesServiceInput

    fun connectionInteractor(): NetworkConnectionInteractor
}