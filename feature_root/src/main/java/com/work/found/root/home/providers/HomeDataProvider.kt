package com.work.found.root.home.providers

import com.work.found.core.base.state.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface HomeDataProvider : DataProvider {

    val isNetworkConnected: StateFlow<Boolean>
}

class HomeDataProviderImpl : HomeDataProvider {

    override val isNetworkConnected = MutableStateFlow(true)
}