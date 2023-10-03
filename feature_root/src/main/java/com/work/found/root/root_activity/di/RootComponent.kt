package com.work.found.root.root_activity.di

import com.work.found.root.root_activity.presenter.RootPresenter
import com.work.found.root.root_activity.router.RootRouterImpl
import com.work.found.root.root_activity.router.RootRouterInput
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class RootScope

@RootScope
@Component(
    dependencies = [RootDependencies::class],
    modules = [RootModule::class]
)
interface RootComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependencies: RootDependencies): Builder

        fun build(): RootComponent
    }

    fun inject(target: RootPresenter)
}

interface RootDependencies

@Module
class RootModule {

    @Provides
    @RootScope
    fun provideRouter(): RootRouterInput = RootRouterImpl()
}