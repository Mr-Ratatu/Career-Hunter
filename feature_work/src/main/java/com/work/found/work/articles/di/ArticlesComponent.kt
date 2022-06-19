package com.work.found.work.articles.di

import com.work.found.core.di.dependencies.ArticlesDependencies
import com.work.found.work.articles.presenter.ArticlesPresenter
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