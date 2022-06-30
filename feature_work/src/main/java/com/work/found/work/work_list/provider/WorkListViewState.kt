package com.work.found.work.work_list.provider

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.extensions.safetyValue
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.States

class WorkListViewStateImpl : WorkListViewStateInput {

    override val dataProvider = WorkListDataProviderImpl()

    override fun updateWorkList(work: WorkResponse) {
        dataProvider.workListValues.safetyValue(work)
    }

    override fun updateArticles(articlesList: List<ArticlesItem>) {
        dataProvider.articlesValue.safetyValue(articlesList)
    }

    override fun updateState(state: States) {
        dataProvider.states.value = state
    }
}

interface WorkListViewStateInput : ViewState<WorkListDataProvider> {
    fun updateWorkList(work: WorkResponse)
    fun updateArticles(articlesList: List<ArticlesItem>)
    fun updateState(state: States)
}