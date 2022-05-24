package com.work.found.splash.di

import com.work.found.core.di.dependencies.SplashDependencies
import com.work.found.splash.presenter.SplashPresenter
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SplashScope

@SplashScope
@Component(
    dependencies = [SplashDependencies::class]
)
interface SplashComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependency: SplashDependencies): Builder

        fun build(): SplashComponent
    }

    fun inject(target: SplashPresenter)
}