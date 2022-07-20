package com.work.found.core.base.delegates

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow

interface FlowMethodsDelegate {

    fun registerLifecycleCoroutineScope(scope: LifecycleCoroutineScope)

    fun <T> Flow<T>.launchWhenStartedWithScope(block: (T) -> Unit)
}