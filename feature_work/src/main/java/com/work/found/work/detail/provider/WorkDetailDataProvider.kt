package com.work.found.work.detail.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.utils.SingleLiveEvent
import com.work.found.core.base.utils.States

interface WorkDetailDataProviderInput : DataProvider {
    val detailInfo: LiveData<WorkDetailResponse>
    val states: LiveData<Result<WorkDetailResponse>>
}

class WorkDetailDataProviderImpl : WorkDetailDataProviderInput {
    override val detailInfo = MutableLiveData<WorkDetailResponse>()

    override val states = SingleLiveEvent<Result<WorkDetailResponse>>(Result.Loading)
}