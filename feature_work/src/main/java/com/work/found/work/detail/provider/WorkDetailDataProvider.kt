package com.work.found.work.detail.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.utils.SingleLiveEvent
import com.work.found.core.base.utils.States
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface WorkDetailDataProviderInput : DataProvider {
    val detailInfo: LiveData<WorkDetailResponse>
    val states: Flow<States>
    val showSkeleton: Flow<Boolean>
}

class WorkDetailDataProviderImpl : WorkDetailDataProviderInput {
    override val detailInfo = MutableLiveData<WorkDetailResponse>()

    override val states = MutableStateFlow(States.LOADING)

    override val showSkeleton = states.map { it == States.LOADING }
}