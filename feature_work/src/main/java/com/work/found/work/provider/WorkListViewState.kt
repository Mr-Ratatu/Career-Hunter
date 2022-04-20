package com.work.found.work.provider

import com.work.found.core.base.state.ViewState

class WorkListViewStateImpl : WorkListViewStateInput {

    override val dataProvider = WorkListDataProviderImpl()

    override fun setWorkList(work: Unit) {
        dataProvider.workListValues.value = work
    }
}

interface WorkListViewStateInput : ViewState<WorkListDataProvider> {

    fun setWorkList(work: Unit)
}