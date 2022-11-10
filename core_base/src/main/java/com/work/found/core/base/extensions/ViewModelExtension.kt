package com.work.found.core.base.extensions

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Extension for simplifying viewModel initialization
 * @parameter builder is more concrete than ViewModelProvider.Factory and return concrete instance of viewModel
 * Use this
 * class CustomViewModel(val param: Int) : ViewModel()
 * val viewModel by viewModels(builder = { CustomViewModel(42) })
 * or this
 * class EmptyViewModel : ViewModel()
 * val emptyViewModel by viewModels(builder = ::EmptyViewModel)
 */
@MainThread
inline fun <reified VM : ViewModel> Fragment.viewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline builder: (() -> VM)? = null,
): Lazy<VM> = createViewModelLazy(
    viewModelClass = VM::class, storeProducer = { ownerProducer().viewModelStore },
    factoryProducer = builder?.let { factory(it) },
)

@Suppress("UNCHECKED_CAST")
inline fun <reified VM : ViewModel> factory(noinline builder: () -> VM): () -> ViewModelProvider.Factory {
    return {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T = builder.invoke() as T
        }
    }
}
