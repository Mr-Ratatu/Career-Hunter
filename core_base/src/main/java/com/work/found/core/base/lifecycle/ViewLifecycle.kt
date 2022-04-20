package com.work.found.core.base.lifecycle

import androidx.lifecycle.LifecycleOwner

interface ViewLifecycle {
    fun <T : LifecycleOwner> onAttachView(view: T)
    fun <T : LifecycleOwner> onShowView(view: T)
    fun <T : LifecycleOwner> onHideView(view: T)
    fun <T : LifecycleOwner> onDetachView(view: T)
}