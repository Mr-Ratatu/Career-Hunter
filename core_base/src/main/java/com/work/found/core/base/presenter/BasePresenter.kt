package com.work.found.core.base.presenter

import androidx.lifecycle.LifecycleOwner
import com.work.found.core.base.presentation.ViewOutput
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.state.ViewStateInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

interface Presenter : ViewOutput {
    val presenterScope: CoroutineScope
    fun provideViewState(): ViewState<*>
}

abstract class BasePresenter<T : ViewStateInput> : Presenter {

    private val _viewState: ViewState<*> by lazy { provideViewState() }
    val dataProvider: DataProvider get() = _viewState.dataProvider
    @Suppress("UNCHECKED_CAST")
    val viewState: T
        get() = _viewState as T

    override val presenterScope = CoroutineScope(Job() + Dispatchers.Main.immediate)

    override fun <T : LifecycleOwner> onAttachView(view: T) = Unit

    override fun <T : LifecycleOwner> onShowView(view: T) = Unit

    override fun <T : LifecycleOwner> onHideView(view: T) = Unit

    override fun <T : LifecycleOwner> onDetachView(view: T) { presenterScope.cancel() }
}