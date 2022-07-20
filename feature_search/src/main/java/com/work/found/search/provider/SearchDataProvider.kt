package com.work.found.search.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.state.DataProvider
import com.work.found.core.base.utils.SingleLiveEvent

interface SearchDataProvider : DataProvider {
    val workList: LiveData<WorkResponse>
    val states: LiveData<Result<WorkResponse>>
}

class SearchDataProviderImpl : SearchDataProvider {

    override val workList = MutableLiveData<WorkResponse>()

    override val states = SingleLiveEvent<Result<WorkResponse>>(Result.Loading)
}