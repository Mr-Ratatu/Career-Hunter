package com.work.found.work.detail.provider

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.ViewState

interface WorkDetailViewStateInput : ViewState<WorkDetailDataProviderInput> {
    fun updateDetailInfo(response: WorkDetailResponse)
    fun updateState(state: Result<WorkDetailResponse>)
}

class WorkDetailViewStateImpl : WorkDetailViewStateInput {

    override val dataProvider = WorkDetailDataProviderImpl()

    override fun updateDetailInfo(response: WorkDetailResponse) {
        dataProvider.detailInfo.value = response
    }

    override fun updateState(state: Result<WorkDetailResponse>) {
        dataProvider.states.value = state
    }
}