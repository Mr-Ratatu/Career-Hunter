package com.work.found.core.base.delegates

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

interface LiveDataMethodsDelegate {

    fun registerViewOwner(viewLifecycle: LifecycleOwner)

    fun <T> LiveData<T>.observeWithViewScope(observable: Observer<T?>)

    fun <T> LiveData<T>.observeWithViewScopeIgnoreNull(block: (value: T) -> Unit)

    fun <T> LiveData<T>.observeWithDistinctUntilChangedIgnoreNull(block: (value: T) -> Unit)
}