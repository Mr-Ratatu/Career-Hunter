package com.work.found.splash.presenter

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.splash.di.DaggerSplashComponent
import com.work.found.splash.provider.SplashViewState
import com.work.found.splash.provider.SplashViewStateImpl
import com.work.found.splash.router.SplashRouterInput
import com.work.found.splash.view.SplashViewOutput
import javax.inject.Inject

class SplashPresenter : BasePresenter<SplashViewState>(), SplashViewOutput {

    @Inject
    lateinit var router: SplashRouterInput

    override fun provideViewState(): ViewState<*> {
        return SplashViewStateImpl()
    }

    init {
        DaggerSplashComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun openHomeScreen(manager: FragmentManager) {
        router.openHomeScreen(manager)
    }
}