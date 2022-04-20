package com.work.found.core.base.presentation

import androidx.lifecycle.LifecycleOwner

interface ViewOutput {
    fun <T : LifecycleOwner> onAttachView(view: T)
    fun <T : LifecycleOwner> onShowView(view: T)
    fun <T : LifecycleOwner> onHideView(view: T)
    fun <T : LifecycleOwner> onDetachView(view: T)
}