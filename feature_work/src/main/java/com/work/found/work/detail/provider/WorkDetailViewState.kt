package com.work.found.work.detail.provider

import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.States

interface WorkDetailViewStateInput : ViewState<WorkDetailDataProviderInput> {
    fun updateDetailInfo(response: WorkDetailResponse)
    fun updateState(state: States)
}

class WorkDetailViewStateImpl : WorkDetailViewStateInput {

    override val dataProvider = WorkDetailDataProviderImpl()

    override fun updateDetailInfo(response: WorkDetailResponse) {
        dataProvider.detailInfo.value = response
    }

    override fun updateState(state: States) {
        dataProvider.states.value = state
    }
}