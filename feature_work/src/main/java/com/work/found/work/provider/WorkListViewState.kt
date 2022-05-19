package com.work.found.work.provider

import com.work.found.core.api.model.news.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.ViewState

class WorkListViewStateImpl : WorkListViewStateInput {

    override val dataProvider = WorkListDataProviderImpl()

    override fun updateWorkList(work: WorkResponse) {
        dataProvider.workListValues.postValue(work)
    }

    override fun updateError(error: Throwable) {
        dataProvider.errorValue.value = error
    }

    override fun updateLoading(isLoading: Boolean) {
        dataProvider.loadingValue.postValue(isLoading)
    }

    override fun updateArticles(articlesList: List<ArticlesItem>) {
        dataProvider.articlesValue.value = articlesList
    }
}

interface WorkListViewStateInput : ViewState<WorkListDataProvider> {
    fun updateWorkList(work: WorkResponse)
    fun updateError(error: Throwable)
    fun updateLoading(isLoading: Boolean)
    fun updateArticles(articlesList: List<ArticlesItem>)
}