package com.work.found.di.modules

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkListServiceInput
import com.work.found.core.implementation.ArticlesServiceImpl
import com.work.found.core.implementation.WorkListServiceImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ServiceModule {

    @Binds
    @Singleton
    fun bindWorkListService(service: WorkListServiceImpl): WorkListServiceInput

    @Binds
    @Singleton
    fun bindArticlesService(service: ArticlesServiceImpl): ArticlesServiceInput
}