package com.work.found.work.work_list.provider

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.ViewState

class WorkListViewStateImpl : WorkListViewStateInput {

    override val dataProvider = WorkListDataProviderImpl()

    override fun updateWorkList(work: WorkResponse) {
        dataProvider.workListValues.value = work
    }

    override fun updateArticles(articlesList: List<ArticlesItem>) {
        dataProvider.articlesValue.value = articlesList
    }

    override fun updateState(state: Result<WorkResponse>) {
        dataProvider.states.value = state
    }
}

interface WorkListViewStateInput : ViewState<WorkListDataProvider> {
    fun updateWorkList(work: WorkResponse)
    fun updateArticles(articlesList: List<ArticlesItem>)
    fun updateState(state: Result<WorkResponse>)
}