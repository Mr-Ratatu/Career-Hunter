package com.work.found.root.home.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.HomeRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class HomeRoutingModuleImpl : HomeRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = HomeFragment::class as KClass<LifecycleOwner>
}