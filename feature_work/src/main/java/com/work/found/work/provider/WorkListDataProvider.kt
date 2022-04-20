package com.work.found.work.provider

import com.work.found.core.base.state.DataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface WorkListDataProvider : DataProvider {
    val workListValues: StateFlow<Unit>
}

class WorkListDataProviderImpl : WorkListDataProvider {

    override val workListValues = MutableStateFlow<Unit>(Unit)
}