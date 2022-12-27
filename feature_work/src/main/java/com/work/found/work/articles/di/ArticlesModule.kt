package com.work.found.work.articles.di

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.work.articles.interactor.ArticlesInteractorImpl
import com.work.found.work.articles.interactor.ArticlesInteractorInput
import com.work.found.work.articles.router.ArticlesRouterImpl
import com.work.found.work.articles.router.ArticlesRouterInput
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule {

    @Provides
    @ArticlesScope
    fun provideInteractor(service: ArticlesServiceInput): ArticlesInteractorInput {
        return ArticlesInteractorImpl(service)
    }

    @Provides
    @ArticlesScope
    fun providesArticlesRouter(): ArticlesRouterInput = ArticlesRouterImpl()
}