package com.work.found.work.work_list.domain

import androidx.paging.PagingData
import com.work.found.core.api.model.work.Works
import kotlinx.coroutines.flow.Flow

interface WorkListRepository {
    fun search(query: String): Flow<PagingData<Works>>
}