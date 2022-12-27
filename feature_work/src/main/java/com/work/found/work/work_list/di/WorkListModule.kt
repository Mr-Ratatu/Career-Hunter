package com.work.found.work.work_list.di

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.work_list.interactor.WorkListInteractorImpl
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import com.work.found.work.work_list.router.WorkListRouter
import com.work.found.work.work_list.router.WorkListRouterInput
import dagger.Module
import dagger.Provides

@Module
class WorkListModule {

    @Provides
    @WorkListScope
    fun providesInteractor(
        workService: WorkServiceInput,
        articlesService: ArticlesServiceInput
    ): WorkListInteractorInput {
        return WorkListInteractorImpl(workService, articlesService)
    }

    @Provides
    @WorkListScope
    fun providesWorkListRouter(): WorkListRouterInput = WorkListRouter()
}