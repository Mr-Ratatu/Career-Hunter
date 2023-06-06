package com.work.found.core.api.interactors

import kotlinx.coroutines.flow.Flow

interface NetworkConnectionInteractor {
    val isNetworkConnectedCallback: Flow<Boolean>
}