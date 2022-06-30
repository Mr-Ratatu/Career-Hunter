package com.work.found.di.modules

import com.work.found.auth.router.AuthRouterImpl
import com.work.found.core.api.router.*
import com.work.found.splash.router.SplashRouter
import com.work.found.work.articles.router.ArticlesRouterImpl
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

    @Binds
    @Singleton
    fun bindArticlesRouter(router: ArticlesRouterImpl): ArticlesRouterInput

    @Binds
    @Singleton
    fun bindAuthRouter(router: AuthRouterImpl): AuthRouterInput
}