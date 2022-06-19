package com.work.found.work.articles.di

import com.work.found.work.articles.interactor.ArticlesInteractorImpl
import com.work.found.work.articles.interactor.ArticlesInteractorInput
import dagger.Binds
import dagger.Module

@Module
interface ArticlesModule {

    @Binds
    @ArticlesScope
    fun bindInteractor(interactor: ArticlesInteractorImpl): ArticlesInteractorInput
}