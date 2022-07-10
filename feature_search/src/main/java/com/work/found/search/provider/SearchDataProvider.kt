package com.work.found.search.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.base.state.DataProvider

interface SearchDataProvider : DataProvider {
    val workList: LiveData<WorkResponse>
}

class SearchDataProviderImpl : SearchDataProvider {

    override val workList = MutableLiveData<WorkResponse>()
}