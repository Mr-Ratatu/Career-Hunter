package com.work.found.di.modules

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.SearchServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.implementation.ArticlesServiceImpl
import com.work.found.core.implementation.SearchServiceImpl
import com.work.found.core.implementation.WorkServiceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ServiceModule {

    @Binds
    @Singleton
    fun bindWorkListService(service: WorkServiceImpl): WorkServiceInput

    @Binds
    @Singleton
    fun bindArticlesService(service: ArticlesServiceImpl): ArticlesServiceInput

    @Binds
    @Singleton
    fun bindSearchService(service: SearchServiceImpl): SearchServiceInput
}