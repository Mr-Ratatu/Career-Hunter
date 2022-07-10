package com.work.found.search.di

import com.work.found.core.di.dependencies.SearchDependencies
import com.work.found.search.presenter.SearchPresenter
import dagger.Component
import javax.inject.Scope

@Scope
annotation class SearchScope

@SearchScope
@Component(
    modules = [SearchModule::class],
    dependencies = [SearchDependencies::class]
)
interface SearchComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: SearchDependencies): Builder

        fun build(): SearchComponent
    }

    fun inject(target: SearchPresenter)
}