package com.work.found.work.detail.di

import com.work.found.work.detail.interactor.WorkDetailInteractorImpl
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import dagger.Binds
import dagger.Module

@Module
interface WorkDetailModule {

    @Binds
    @WorkDetailScope
    fun bindInteractor(interactor: WorkDetailInteractorImpl): WorkDetailInteractorInput
}