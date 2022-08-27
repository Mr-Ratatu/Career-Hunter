package com.work.found.work.work_list.di

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.base.delegates.NetworkConnectionManager
import com.work.found.core.base.delegates.NetworkConnectionManagerImpl
import com.work.found.work.work_list.interactor.WorkListInteractorImpl
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

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
    fun provideNetworkConnectionManager(coroutineScope: CoroutineScope): NetworkConnectionManager {
        return NetworkConnectionManagerImpl(coroutineScope)
    }
}