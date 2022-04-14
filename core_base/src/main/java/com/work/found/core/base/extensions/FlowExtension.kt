package com.work.found.core.base.extensions

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.launchWhenStarted(coroutineScope: LifecycleCoroutineScope, block: (T) -> Unit) {
    coroutineScope.launchWhenCreated {
        this@launchWhenStarted.collect {
            block.invoke(it)
        }
    }
}

/**
 * Compares how much time has passed since the last click
 */
fun <T> Flow<T>.throttleAfterFirst(duration: Long = 1000L): Flow<T> = flow {
    var lastEmissionTime = 0L
    collect { upstream ->
        val currentTime = System.currentTimeMillis()
        val mayEmit = currentTime - lastEmissionTime > duration
        if (mayEmit) {
            lastEmissionTime = currentTime
            emit(upstream)
        }
    }
}