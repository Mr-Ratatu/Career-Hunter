package com.work.found.core.base.delegates

import androidx.lifecycle.LifecycleCoroutineScope
import com.work.found.core.base.extensions.launchWhenStarted
import kotlinx.coroutines.flow.Flow

class FlowMethodsDelegateImpl : FlowMethodsDelegate {

    private lateinit var scope: LifecycleCoroutineScope

    override fun registerLifecycleCoroutineScope(scope: LifecycleCoroutineScope) {
        this.scope = scope
    }

    override fun <T> Flow<T>.launchWhenStartedWithScope(block: (T) -> Unit) {
        this.launchWhenStarted(scope, block)
    }

}