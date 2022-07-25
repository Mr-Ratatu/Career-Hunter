package com.work.found.splash.presenter

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.HomeRouterInput
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.splash.di.DaggerSplashComponent
import com.work.found.splash.provider.SplashViewState
import com.work.found.splash.provider.SplashViewStateImpl
import com.work.found.splash.view.SplashViewOutput
import javax.inject.Inject

class SplashPresenter : BasePresenter<SplashViewState>(), SplashViewOutput {

    @Inject
    lateinit var router: WorkListRouterInput

    @Inject
    lateinit var homeRouter: HomeRouterInput

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

    override fun openWorkListScreen(manager: FragmentManager) {
        router.openWorkListScreen(manager)
    }

    override fun openHomeScreen(manager: FragmentManager) {
        homeRouter.openHomeScreen(manager)
    }
}