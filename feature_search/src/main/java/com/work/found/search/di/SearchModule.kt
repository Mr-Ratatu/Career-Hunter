package com.work.found.search.di

import com.work.found.core.api.services.WorkServiceInput
import com.work.found.search.interactor.SearchInteractorImpl
import com.work.found.search.interactor.SearchInteractorInput
import com.work.found.search.router.SearchRouterImpl
import com.work.found.search.router.SearchRouterInput
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    @SearchScope
    fun provideInteractor(workService: WorkServiceInput): SearchInteractorInput {
        return SearchInteractorImpl(workService)
    }

    @Provides
    @SearchScope
    fun providesSearchRouter(): SearchRouterInput = SearchRouterImpl()
}