package com.work.found.work.work_list.domain

import androidx.paging.PagingData
import com.work.found.core.api.model.work.Works
import kotlinx.coroutines.flow.Flow

class WorkListUseCase(
    private val repository: WorkListRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Works>> = repository.search(query)
}