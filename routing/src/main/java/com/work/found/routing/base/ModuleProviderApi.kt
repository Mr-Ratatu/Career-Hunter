package com.work.found.routing.base

import kotlin.reflect.KClass

interface ModuleProviderApi {
    fun <T : RoutingModule> provideModule(clazz: KClass<T>): RoutingModule
}