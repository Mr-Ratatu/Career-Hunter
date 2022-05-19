package com.work.found.work.di

import com.work.found.core.di.dependencies.WorkListDependencies
import com.work.found.work.presenter.WorkListPresenter
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkListScope

@WorkListScope
@Component(
    modules = [WorkListModule::class],
    dependencies = [WorkListDependencies::class]
)
interface WorkListComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: WorkListDependencies): Builder

        fun build(): WorkListComponent
    }

    fun inject(target: WorkListPresenter)
}