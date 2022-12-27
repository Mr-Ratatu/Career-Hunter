package com.work.found.work.work_list.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.WorkListRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class WorkListRoutingModuleImpl: WorkListRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = WorkListFragment::class as KClass<LifecycleOwner>
}