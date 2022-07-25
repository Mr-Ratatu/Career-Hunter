package com.work.found.root.root_activity.di

import com.work.found.core.di.dependencies.RootDependencies
import com.work.found.root.root_activity.presenter.RootPresenter
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RootScope

@RootScope
@Component(dependencies = [RootDependencies::class])
interface RootComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: RootDependencies): Builder

        fun build(): RootComponent
    }

    fun inject(target: RootPresenter)
}