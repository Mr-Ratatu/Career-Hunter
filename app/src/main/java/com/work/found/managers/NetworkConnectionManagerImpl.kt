package com.work.found.managers

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.core.content.getSystemService
import com.work.found.core.api.managers.NetworkConnectionManager
import com.work.found.core.base.utils.AppConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update

class NetworkConnectionManagerImpl(context: Context) : NetworkConnectionManager {

    private val connectivityManager: ConnectivityManager? = context.getSystemService()

    private val request = NetworkRequest.Builder().addNetworkCapabilities().build()

    override val isNetworkConnectedCallback = callbackFlow {
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) { trySend(true) }

            override fun onLost(network: Network) { trySend(false) }

            override fun onUnavailable() { trySend(false) }
        }

        connectivityManager?.registerNetworkCallback(request, networkCallback)

        awaitClose { connectivityManager?.unregisterNetworkCallback(networkCallback) }
    }.distinctUntilChanged().flowOn(Dispatchers.IO)

    private fun (NetworkRequest.Builder).addNetworkCapabilities(): NetworkRequest.Builder {
        return addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .addTransportType(NetworkCapabilities.TRANSPORT_ETHERNET)
            .addCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}