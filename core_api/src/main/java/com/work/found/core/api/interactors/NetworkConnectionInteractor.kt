package com.work.found.core.api.interactors

import kotlinx.coroutines.flow.StateFlow

interface NetworkConnectionInteractor {
    val isNetworkConnectedFlow: StateFlow<Boolean>
    fun startListenNetworkState()
    fun stopListenNetworkState()
}