package com.work.found.work.di

import com.work.found.work.interactor.WorkListInteractorImpl
import com.work.found.work.interactor.WorkListInteractorInput
import dagger.Binds
import dagger.Module

@Module
interface WorkListModule {

    @Binds
    @WorkListScope
    fun bindInteractor(interactor: WorkListInteractorImpl): WorkListInteractorInput
}