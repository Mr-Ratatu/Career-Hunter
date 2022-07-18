package com.work.found.search.provider

import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.ViewState

interface SearchViewState : ViewState<SearchDataProvider> {
    fun updateState(state: Result<WorkResponse>)
}

class SearchViewStateImpl : SearchViewState {

    override val dataProvider = SearchDataProviderImpl()

    override fun updateState(state: Result<WorkResponse>) {
        dataProvider.states.postValue(state)
    }
}