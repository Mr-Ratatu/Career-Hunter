package com.work.found.di.modules

import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.core.api.services.SearchServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.articles.impl.data.ArticlesServiceImpl
import com.work.found.core.implementation.services.SearchServiceImpl
import com.work.found.core.implementation.services.WorkServiceImpl
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
    fun bindArticlesService(service: ArticlesServiceImpl): ArticlesService

    @Binds
    @Singleton
    fun bindSearchService(service: SearchServiceImpl): SearchServiceInput
}