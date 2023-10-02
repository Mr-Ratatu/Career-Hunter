package com.work.found

import com.work.found.auth.view.AuthRoutingModuleImpl
import com.work.found.root.home.view.HomeRoutingModuleImpl
import com.work.found.routing.base.ModuleProviderApi
import com.work.found.routing.base.RoutingModule
import com.work.found.routing.modules.*
import com.work.found.search.view.SearchRoutingModuleImpl
import com.work.found.splash.view.SplashRoutingModuleImpl
import com.work.found.work.articles.impl.view.ArticlesRoutingModuleImpl
import com.work.found.work.detail.view.WorkDetailModuleImpl
import com.work.found.work.work_list.view.WorkListRoutingModuleImpl
import kotlin.reflect.KClass

class ModuleProvider : ModuleProviderApi {

    override fun <T : RoutingModule> provideModule(clazz: KClass<T>): RoutingModule {
        return when (clazz) {
            WorkDetailRoutingModule::class -> WorkDetailModuleImpl()
            WorkListRoutingModule::class -> WorkListRoutingModuleImpl()
            ArticlesRoutingModule::class -> ArticlesRoutingModuleImpl()
            SearchRoutingModule::class -> SearchRoutingModuleImpl()
            SplashRoutingModule::class -> SplashRoutingModuleImpl()
            HomeRoutingModule::class -> HomeRoutingModuleImpl()
            AuthRoutingModule::class -> AuthRoutingModuleImpl()
            else -> throw IllegalArgumentException("Not found new module clazz in provideModule")
        }
    }
}