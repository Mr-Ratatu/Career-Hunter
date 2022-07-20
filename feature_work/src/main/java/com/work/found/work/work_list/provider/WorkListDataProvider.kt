package com.work.found.work.work_list.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface WorkListDataProvider : DataProvider {
    val workListValues: LiveData<WorkResponse>
    val articlesValue: LiveData<List<ArticlesItem>>
    val states: StateFlow<Result<WorkResponse>>
}

class WorkListDataProviderImpl : WorkListDataProvider {

    override val workListValues = MutableLiveData<WorkResponse>()

    override val articlesValue = MutableLiveData<List<ArticlesItem>>()

    override val states = MutableStateFlow<Result<WorkResponse>>(Result.Loading)
}