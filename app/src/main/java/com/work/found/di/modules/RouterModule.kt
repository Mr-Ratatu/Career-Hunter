package com.work.found.di.modules

import com.work.found.auth.router.AuthRouterImpl
import com.work.found.core.api.router.*
import com.work.found.root.home.router.HomeRouterImpl
import com.work.found.search.router.SearchRouterImpl
import com.work.found.splash.router.SplashRouter
import com.work.found.work.articles.router.ArticlesRouterImpl
import com.work.found.work.detail.router.WorkDetailRouterImpl
import com.work.found.work.work_list.router.WorkListRouter
import dagger.Provides
import dagger.Module
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @Singleton
    fun providesWorkListRouter(): WorkListRouterInput = WorkListRouter()

    @Provides
    @Singleton
    fun providesSplashRouter(): SplashRouterInput = SplashRouter()

    @Provides
    @Singleton
    fun providesWorkDetailRouter(): WorkDetailRouterInput = WorkDetailRouterImpl()

    @Provides
    @Singleton
    fun providesArticlesRouter(): ArticlesRouterInput = ArticlesRouterImpl()

    @Provides
    @Singleton
    fun providesSearchRouter(): SearchRouterInput = SearchRouterImpl()

    @Provides
    @Singleton
    fun providesAuthRouter(): AuthRouterInput = AuthRouterImpl()

    @Provides
    @Singleton
    fun providesHomeRouter(): HomeRouterInput = HomeRouterImpl()
}