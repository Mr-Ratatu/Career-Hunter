package com.work.found.splash.di

import com.work.found.splash.presenter.SplashPresenter
import com.work.found.splash.router.SplashRouter
import com.work.found.splash.router.SplashRouterInput
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SplashScope

@SplashScope
@Component(
    dependencies = [SplashDependencies::class],
    modules = [SplashModule::class]
)
interface SplashComponent {

    @Component.Builder
    interface Builder {

        fun dependencies(dependency: SplashDependencies): Builder

        fun build(): SplashComponent
    }

    fun inject(target: SplashPresenter)
}

interface SplashDependencies

@Module
class SplashModule {

    @Provides
    @SplashScope
    fun providesSplashRouter(): SplashRouterInput = SplashRouter()
}