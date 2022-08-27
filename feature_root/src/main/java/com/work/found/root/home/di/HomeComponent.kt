package com.work.found.root.home.di

import com.work.found.core.di.dependencies.HomeDependencies
import com.work.found.core.base.delegates.NetworkConnectionManager
import com.work.found.core.base.delegates.NetworkConnectionManagerImpl
import com.work.found.root.home.presenter.HomePresenter
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Singleton
@Component(dependencies = [HomeDependencies::class], modules = [HomeModule::class])
interface HomeComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun coroutineScope(scope: CoroutineScope): Builder

        fun dependencies(dependencies: HomeDependencies): Builder

        fun build(): HomeComponent
    }

    fun inject(target: HomePresenter)
}

@Module
class HomeModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionManager(coroutineScope: CoroutineScope): NetworkConnectionManager {
        return NetworkConnectionManagerImpl(coroutineScope)
    }
}