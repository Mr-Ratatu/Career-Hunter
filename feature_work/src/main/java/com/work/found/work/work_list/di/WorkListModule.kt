package com.work.found.work.work_list.di

import com.work.found.core.api.network_service.WorksNetworkDataSource
import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.work_list.data.WorkListRepositoryImpl
import com.work.found.work.work_list.domain.WorkListInteractorImpl
import com.work.found.work.work_list.domain.WorkListInteractorInput
import com.work.found.work.work_list.domain.WorkListRepository
import com.work.found.work.work_list.domain.WorkListUseCase
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

    @Provides
    @WorkListScope
    fun provideRepository(source: WorksNetworkDataSource): WorkListRepository {
        return WorkListRepositoryImpl(source)
    }

    @Provides
    @WorkListScope
    fun provideUseCase(repository: WorkListRepository) = WorkListUseCase(repository)
}