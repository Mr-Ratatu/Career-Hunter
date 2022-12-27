package com.work.found.routing.base

import androidx.lifecycle.LifecycleOwner
import kotlin.reflect.KClass

interface RoutingModule {
    fun createModule(): KClass<LifecycleOwner>
}