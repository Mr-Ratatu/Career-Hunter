package com.work.found.routing.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

object AppModules {

    private lateinit var moduleProvider: ModuleProviderApi

    fun initModuleProvider(moduleProvider: ModuleProviderApi) {
        AppModules.moduleProvider = moduleProvider
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : RoutingModule> moduleClass(clazz: KClass<T>): KClass<out Fragment> {
        return moduleProvider.provideModule(clazz).createModule() as KClass<out Fragment>
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : RoutingModule> moduleInstance(clazz: KClass<T>, bundle: Bundle?): Fragment {
        return FragmentFactory.createFragment(moduleClass(clazz).java, bundle)
    }
}