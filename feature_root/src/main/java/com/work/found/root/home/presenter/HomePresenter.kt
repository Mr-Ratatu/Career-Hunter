package com.work.found.root.home.presenter

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.root.home.di.DaggerHomeComponent
import com.work.found.root.home.providers.HomeViewStateImpl
import com.work.found.root.home.providers.HomeViewStateInput
import com.work.found.root.home.view.HomeViewOutput
import javax.inject.Inject

class HomePresenter : BasePresenter<HomeViewStateInput>(), HomeViewOutput {

    @Inject
    lateinit var workListRouter: WorkListRouterInput

    init {
        DaggerHomeComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun provideViewState(): ViewState<*> {
        return HomeViewStateImpl()
    }

    override fun onNavigationToWorkList(manager: FragmentManager) {
        workListRouter.openWorkListScreen(manager)
    }
}