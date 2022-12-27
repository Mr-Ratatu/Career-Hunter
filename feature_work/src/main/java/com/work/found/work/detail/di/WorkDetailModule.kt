package com.work.found.work.detail.di

import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.detail.interactor.WorkDetailInteractorImpl
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import com.work.found.work.detail.router.WorkDetailRouterImpl
import com.work.found.work.detail.router.WorkDetailRouterInput
import dagger.Module
import dagger.Provides

@Module
class WorkDetailModule {

    @Provides
    @WorkDetailScope
    fun provideInteractor(workService: WorkServiceInput): WorkDetailInteractorInput {
        return WorkDetailInteractorImpl(workService)
    }

    @Provides
    @WorkDetailScope
    fun providesWorkDetailRouter(): WorkDetailRouterInput = WorkDetailRouterImpl()
}