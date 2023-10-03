package com.work.found.di.modules

import com.work.found.core.api.network_service.ApiProvider
import com.work.found.core.api.network_service.WorksNetworkDataSource
import com.work.found.core.implementation.network.WorksNetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideWorksNetworkDataSource(apiProvider: ApiProvider): WorksNetworkDataSource {
        return WorksNetworkDataSourceImpl(apiProvider)
    }
}