package com.work.found.work.detail.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.WorkDetailRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class WorkDetailModuleImpl : WorkDetailRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = WorkDetailFragment::class as KClass<LifecycleOwner>
}