package com.work.found.work.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.DataProvider

interface WorkListDataProvider : DataProvider {
    val workListValues: LiveData<WorkResponse>
    val errorValue: LiveData<Throwable>
    val loadingValue: LiveData<Boolean>
    val articlesValue: LiveData<List<ArticlesItem>>
}

class WorkListDataProviderImpl : WorkListDataProvider {

    override val workListValues = MutableLiveData<WorkResponse>()

    override val errorValue = MutableLiveData<Throwable>()

    override val loadingValue = MutableLiveData<Boolean>()

    override val articlesValue = MutableLiveData<List<ArticlesItem>>()
}