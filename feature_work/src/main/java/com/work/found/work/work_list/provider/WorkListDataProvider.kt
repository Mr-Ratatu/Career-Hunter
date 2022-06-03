package com.work.found.work.work_list.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.utils.SingleLiveEvent
import com.work.found.core.base.utils.States

interface WorkListDataProvider : DataProvider {
    val workListValues: LiveData<WorkResponse>
    val articlesValue: LiveData<List<ArticlesItem>>
    val states: LiveData<States>
}

class WorkListDataProviderImpl : WorkListDataProvider {

    override val workListValues = MutableLiveData<WorkResponse>()

    override val articlesValue = MutableLiveData<List<ArticlesItem>>()

    override val states = SingleLiveEvent(States.LOADING)
}