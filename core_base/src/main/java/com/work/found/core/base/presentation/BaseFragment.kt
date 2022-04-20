package com.work.found.core.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.work.found.core.base.extensions.popBackStack
import com.work.found.core.base.lifecycle.ViewLifecycle
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.DataProvider

abstract class BaseFragment<T : ViewOutput, D : DataProvider> :
    Fragment(),
    ViewLifecycle,
    OnBackPressedListener {

    abstract val layoutId: Int

    private lateinit var _viewOutput: T
    val viewOutput: T get() = _viewOutput

    private lateinit var _dataProvider: D
    val dataProvider: D get() = _dataProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onAttachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        subscribeOnData()
        setInsetListener(view)

        _viewOutput = initViewOutput()
        @Suppress("UNCHECKED_CAST")
        _dataProvider = (viewOutput as BasePresenter<*>).dataProvider as D
    }

    override fun onResume() {
        super.onResume()
        onShowView(this)
    }

    override fun onStop() {
        super.onStop()
        onHideView(this)
    }

    final override fun onDestroy() {
        super.onDestroy()
        onDetachView(this)
    }

    override fun <T : LifecycleOwner> onAttachView(view: T) {
        _viewOutput.onAttachView(view)
    }

    override fun <T : LifecycleOwner> onShowView(view: T) {
        _viewOutput.onShowView(view)
    }

    override fun <T : LifecycleOwner> onHideView(view: T) {
        _viewOutput.onHideView(view)
    }

    override fun <T : LifecycleOwner> onDetachView(view: T) {
        _viewOutput.onDetachView(view)
    }

    override fun onBackPressed(callback: () -> Unit) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    callback.invoke()
                    popBackStack()
                }
            })
    }

    protected abstract fun initViewOutput(): T

    protected abstract fun initView()

    protected abstract fun subscribeOnData()

    protected abstract fun setInsetListener(rootView: View)

}