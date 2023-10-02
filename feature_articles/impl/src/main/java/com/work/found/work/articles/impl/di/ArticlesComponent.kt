package com.work.found.work.articles.impl.di

import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.domain.ArticleDetailUseCase
import com.work.found.work.articles.impl.presenter.ArticlesPresenter
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ArticlesScope

@ArticlesScope
@Component(
    modules = [ArticlesModule::class],
    dependencies = [ArticlesDependencies::class]
)
interface ArticlesComponent {

    @Component.Builder
    interface Build {
        fun dependencies(dependencies: ArticlesDependencies): Build
        fun build(): ArticlesComponent
    }

    fun inject(target: ArticlesPresenter)
}

interface ArticlesDependencies {
    fun articlesService(): ArticlesService
    fun articlesDetailUseCase(): ArticleDetailUseCase
}