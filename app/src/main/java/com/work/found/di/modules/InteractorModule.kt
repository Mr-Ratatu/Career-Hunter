package com.work.found.di.modules

import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.managers.NetworkConnectionManager
import com.work.found.core.implementation.interactors.NetworkConnectionInteractorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionInteractor(
        networkConnectionManager: NetworkConnectionManager
    ): NetworkConnectionInteractor {
        return NetworkConnectionInteractorImpl(networkConnectionManager)
    }
}