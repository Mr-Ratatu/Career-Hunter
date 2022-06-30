package com.work.found.work.work_list.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.utils.States
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface WorkListDataProvider : DataProvider {
    val workListValues: LiveData<WorkResponse>
    val articlesValue: LiveData<List<ArticlesItem>>
    val states: Flow<States>
    val showSkeleton: Flow<Boolean>
    val error: Flow<Boolean>
}

class WorkListDataProviderImpl : WorkListDataProvider {

    override val workListValues = MutableLiveData<WorkResponse>()

    override val articlesValue = MutableLiveData<List<ArticlesItem>>()

    override val states = MutableStateFlow(States.LOADING)

    override val showSkeleton = states.map { it == States.LOADING }

    override val error = states.map { it == States.ERROR }
}