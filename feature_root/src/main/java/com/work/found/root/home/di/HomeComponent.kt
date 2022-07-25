package com.work.found.root.home.di

import com.work.found.core.di.dependencies.HomeDependencies
import com.work.found.root.home.presenter.HomePresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [HomeDependencies::class])
interface HomeComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: HomeDependencies): Builder

        fun build(): HomeComponent
    }

    fun inject(target: HomePresenter)
}