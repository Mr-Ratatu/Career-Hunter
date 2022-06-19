package com.work.found.core.base.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.DataProvider

abstract class BaseActivity<T : ViewOutput, D : DataProvider> : AppCompatActivity() {

    protected abstract val layoutId: Int

    private lateinit var _viewOutput: T
    val viewOutput: T get() = _viewOutput

    private lateinit var _dataProvider: D
    val dataProvider: D get() = _dataProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        _viewOutput = initViewOutput()
        @Suppress("UNCHECKED_CAST")
        _dataProvider = (viewOutput as BasePresenter<*>).dataProvider as D

        setFullScreen()
    }

    protected abstract fun initViewOutput(): T

    private fun setFullScreen() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}