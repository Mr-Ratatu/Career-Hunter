package com.work.found.di.modules

import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.work.router.WorkListRouterImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RouterModule {

    @Binds
    @Singleton
    fun bindWorkListRouter(router: WorkListRouterImpl): WorkListRouterInput
}