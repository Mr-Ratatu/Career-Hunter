package com.work.found.root.root_activity.presenter

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.HomeRouterInput
import com.work.found.core.api.router.SplashRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.root.root_activity.di.DaggerRootComponent
import com.work.found.root.root_activity.provider.RootViewState
import com.work.found.root.root_activity.provider.RootViewStateImpl
import com.work.found.root.root_activity.view.RootViewOutput
import javax.inject.Inject

class RootPresenter : BasePresenter<RootViewState>(), RootViewOutput {

    @Inject
    lateinit var splashRouter: SplashRouterInput

    @Inject
    lateinit var homeRouter: HomeRouterInput

    init {
        DaggerRootComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun provideViewState(): ViewState<*> {
        return RootViewStateImpl()
    }

    override fun onShowSplashScreen(manager: FragmentManager) {
        splashRouter.showSplashScreen(manager)
    }

    override fun onShowHomeScreen(manager: FragmentManager) {
        homeRouter.openHomeScreen(manager)
    }
}