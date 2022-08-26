package com.work.found.splash.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.splash.R
import com.work.found.splash.presenter.SplashPresenter
import com.work.found.splash.provider.SplashDataProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<SplashViewOutput, SplashDataProvider>() {

    companion object {

        fun newInstance(): SplashFragment {
            return SplashFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(1500)
            viewOutput.openHomeScreen(parentFragmentManager)
        }
    }

    override val layoutId: Int = R.layout.fragment_splash

    override fun initViewOutput(): SplashViewOutput {
        return SplashPresenter()
    }

    override fun initView() = Unit

    override fun subscribeOnData() = Unit

    override fun setInsetListener(rootView: View) = Unit
}