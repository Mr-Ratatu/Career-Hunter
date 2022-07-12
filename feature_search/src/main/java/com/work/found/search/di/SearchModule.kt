package com.work.found.search.di

import com.work.found.search.interactor.SearchInteractorImpl
import com.work.found.search.interactor.SearchInteractorInput
import dagger.Binds
import dagger.Module

@Module
interface SearchModule {

    @Binds
    @SearchScope
    fun bindInteractor(interactor: SearchInteractorImpl): SearchInteractorInput
}