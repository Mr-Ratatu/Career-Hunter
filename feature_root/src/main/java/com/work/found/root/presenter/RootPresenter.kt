package com.work.found.root.presenter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.work.found.core.api.router.SplashRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.root.di.DaggerRootComponent
import com.work.found.root.provider.RootViewState
import com.work.found.root.provider.RootViewStateImpl
import com.work.found.root.view.RootViewOutput
import javax.inject.Inject

class RootPresenter : BasePresenter<RootViewState>(), RootViewOutput {

    @Inject
    lateinit var splashRouter: SplashRouterInput

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

    override fun showSplashScreen(manager: FragmentManager) {
        splashRouter.showSplashScreen(manager)
    }
}