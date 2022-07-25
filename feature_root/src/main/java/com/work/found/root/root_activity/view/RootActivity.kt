package com.work.found.root.root_activity.view

import android.os.Bundle
import com.work.found.core.base.presentation.BaseActivity
import com.work.found.root.root_activity.presenter.RootPresenter
import com.work.found.root.root_activity.provider.RootDataProvider
import com.work.found.core.base.R

class RootActivity : BaseActivity<RootViewOutput, RootDataProvider>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewOutput.onShowSplashScreen(supportFragmentManager)
    }

    override val layoutId: Int = R.layout.main_container

    override fun initViewOutput(): RootViewOutput {
        return RootPresenter()
    }
}