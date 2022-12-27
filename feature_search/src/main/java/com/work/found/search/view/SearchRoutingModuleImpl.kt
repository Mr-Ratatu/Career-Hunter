package com.work.found.search.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.SearchRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class SearchRoutingModuleImpl : SearchRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = SearchFragment::class as KClass<LifecycleOwner>
}