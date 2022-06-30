package com.work.found.core.base.delegates

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.work.found.core.base.extensions.distinctUntilChanged

class LiveDataMethodsMixinDelegate : LiveDataMethodsDelegate {

    private lateinit var viewLifecycle: LifecycleOwner

    override fun registerViewOwner(viewLifecycle: LifecycleOwner) {
        this.viewLifecycle = viewLifecycle
    }

    override fun <T> LiveData<T>.observeWithViewScope(observable: Observer<T?>) {
        this.observe(viewLifecycle, observable)
    }

    override fun <T> LiveData<T>.observeWithViewScopeIgnoreNull(block: (value: T) -> Unit) {
        this.observe(viewLifecycle) { it?.run { block(it) } }
    }

    override fun <T> LiveData<T>.observeWithDistinctUntilChangedIgnoreNull(block: (value: T) -> Unit) {
        this.distinctUntilChanged().observeWithViewScopeIgnoreNull(block)
    }

}