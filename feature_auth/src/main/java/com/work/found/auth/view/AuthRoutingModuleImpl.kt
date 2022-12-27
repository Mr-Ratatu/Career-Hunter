package com.work.found.auth.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.AuthRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class AuthRoutingModuleImpl : AuthRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = AuthFragment::class as KClass<LifecycleOwner>
}