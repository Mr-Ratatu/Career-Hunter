package com.work.found.core.api.managers

import kotlinx.coroutines.flow.Flow

interface NetworkConnectionManager {
    /**
     * Emits [Boolean] value when the current network becomes available or unavailable.
     */
    val isNetworkConnectedCallback: Flow<Boolean>
}