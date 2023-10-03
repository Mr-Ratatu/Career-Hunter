package com.work.found.work.articles.impl.di

import com.work.found.work.articles.impl.router.ArticlesRouterImpl
import com.work.found.work.articles.impl.router.ArticlesRouterInput
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    @ArticlesScope
    fun providesArticlesRouter(): ArticlesRouterInput = ArticlesRouterImpl()
}