package com.work.found.root.home.presenter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.core.base.delegates.NetworkConnectionManager
import com.work.found.root.home.di.DaggerHomeComponent
import com.work.found.root.home.providers.HomeViewStateImpl
import com.work.found.root.home.providers.HomeViewStateInput
import com.work.found.root.home.view.HomeViewOutput
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomePresenter : BasePresenter<HomeViewStateInput>(), HomeViewOutput {

    @Inject
    lateinit var workListRouter: WorkListRouterInput

    @Inject
    lateinit var connectionManager: NetworkConnectionManager

    init {
        DaggerHomeComponent
            .builder()
            .coroutineScope(presenterScope)
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)

        connectionManager.startListenNetworkState()

        connectionManager.isNetworkConnectedFlow.onEach {
            viewState.isNetworkConnected.value = it
        }.launchIn(presenterScope)
    }

    override fun provideViewState(): ViewState<*> {
        return HomeViewStateImpl()
    }

    override fun onNavigationToWorkList(manager: FragmentManager) {
        workListRouter.openWorkListScreen(manager)
    }

    override fun <T : LifecycleOwner> onDetachView(view: T) {
        super.onDetachView(view)
        connectionManager.stopListenNetworkState()
    }
}