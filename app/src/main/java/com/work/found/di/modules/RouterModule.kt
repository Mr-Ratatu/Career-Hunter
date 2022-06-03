package com.work.found.di.modules

import com.work.found.core.api.router.SplashRouterInput
import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.splash.router.SplashRouter
import com.work.found.work.detail.router.WorkDetailRouterImpl
import com.work.found.work.work_list.router.WorkListRouter
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RouterModule {

    @Binds
    @Singleton
    fun bindWorkListRouter(router: WorkListRouter): WorkListRouterInput

    @Binds
    @Singleton
    fun bindSplashRouter(router: SplashRouter): SplashRouterInput

    @Binds
    @Singleton
    fun bindWorkDetailRouter(router: WorkDetailRouterImpl): WorkDetailRouterInput
}