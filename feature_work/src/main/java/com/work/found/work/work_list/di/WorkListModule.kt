package com.work.found.work.work_list.di

import com.work.found.work.work_list.interactor.WorkListInteractorImpl
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import dagger.Binds
import dagger.Module

@Module
interface WorkListModule {

    @Binds
    @WorkListScope
    fun bindInteractor(interactor: WorkListInteractorImpl): WorkListInteractorInput
}