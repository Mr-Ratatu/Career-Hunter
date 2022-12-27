package com.work.found.core.implementation.interactors

import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.managers.NetworkConnectionManager

class NetworkConnectionInteractorImpl(
    private val networkConnectionManager: NetworkConnectionManager
) : NetworkConnectionInteractor {

    override val isNetworkConnectedFlow = networkConnectionManager.isNetworkConnectedFlow

    override fun startListenNetworkState() = networkConnectionManager.startListenNetworkState()

    override fun stopListenNetworkState() = networkConnectionManager.stopListenNetworkState()
}