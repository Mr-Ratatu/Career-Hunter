package com.work.found.splash.di

import com.work.found.core.api.di.dependencies.SplashDependencies
import com.work.found.splash.presentation.SplashFragment
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SplashScope

@SplashScope
@Component(
    modules = [],
    dependencies = [SplashDependencies::class]
)
interface SplashComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependency: SplashDependencies): Builder

        fun build(): SplashComponent
    }

    fun inject(target: SplashFragment)

    companion object {
        fun create(dependency: SplashDependencies): SplashComponent {
            return DaggerSplashComponent
                .builder()
                .dependencies(dependency)
                .build()
        }
    }
}