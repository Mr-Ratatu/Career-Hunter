package com.work.found.root.home.presenter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.root.home.di.DaggerHomeComponent
import com.work.found.root.home.providers.HomeViewStateImpl
import com.work.found.root.home.providers.HomeViewStateInput
import com.work.found.root.home.router.HomeRouterInput
import com.work.found.root.home.view.HomeViewOutput
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomePresenter : BasePresenter<HomeViewStateInput>(), HomeViewOutput {

    @Inject
    lateinit var router: HomeRouterInput

    @Inject
    lateinit var connectionInteractor: NetworkConnectionInteractor

    init {
        DaggerHomeComponent
            .builder()
            .coroutineScope(presenterScope)
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)

        connectionInteractor.isNetworkConnectedCallback.onEach {
            viewState.isNetworkConnected.value = it
        }.launchIn(presenterScope)
    }

    override fun provideViewState(): ViewState<*> {
        return HomeViewStateImpl()
    }

    override fun onNavigationToWorkList(manager: FragmentManager) {
        router.openWorkListScreen(manager)
    }
}