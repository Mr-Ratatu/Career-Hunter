package com.work.found.work.articles.view

import androidx.lifecycle.LifecycleOwner
import com.work.found.routing.modules.ArticlesRoutingModule
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class ArticlesRoutingModuleImpl: ArticlesRoutingModule {
    override fun createModule(): KClass<LifecycleOwner> = ArticlesFragment::class as KClass<LifecycleOwner>
}