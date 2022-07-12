package com.work.found.search.provider

import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.ViewState

interface SearchViewState : ViewState<SearchDataProvider> {
    fun updateWorkList(work: WorkResponse)
}

class SearchViewStateImpl : SearchViewState {

    override val dataProvider = SearchDataProviderImpl()

    override fun updateWorkList(work: WorkResponse) {
        dataProvider.workList.value = work
    }
}