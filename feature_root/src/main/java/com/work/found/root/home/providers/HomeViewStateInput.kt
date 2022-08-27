package com.work.found.root.home.providers

import com.work.found.core.base.state.ViewState
import kotlinx.coroutines.flow.MutableStateFlow

interface HomeViewStateInput : ViewState<HomeDataProvider> {

    val isNetworkConnected: MutableStateFlow<Boolean>
}

class HomeViewStateImpl : HomeViewStateInput {

    override val dataProvider = HomeDataProviderImpl()

    override val isNetworkConnected = dataProvider.isNetworkConnected
}