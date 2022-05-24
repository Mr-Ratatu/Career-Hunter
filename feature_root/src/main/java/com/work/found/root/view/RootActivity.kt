package com.work.found.root.view

import android.os.Bundle
import com.work.found.core.base.presentation.BaseActivity
import com.work.found.root.presenter.RootPresenter
import com.work.found.root.provider.RootDataProvider

class RootActivity : BaseActivity<RootViewOutput, RootDataProvider>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewOutput.showSplashScreen(supportFragmentManager)
    }

    override val layoutId: Int = com.work.found.core.base.R.layout.main_container

    override fun initViewOutput(): RootViewOutput {
        return RootPresenter()
    }
}