package com.work.found.splash.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.SplashRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class SplashRoutingModuleImpl : SplashRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = SplashFragment::class as KClass<LifecycleOwner>
}