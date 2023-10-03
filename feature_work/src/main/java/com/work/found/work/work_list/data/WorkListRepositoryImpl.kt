package com.work.found.work.work_list.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.work.found.core.api.model.work.Works
import com.work.found.core.api.network_service.WorksNetworkDataSource
import com.work.found.work.work_list.domain.WorkListRepository
import kotlinx.coroutines.flow.Flow

class WorkListRepositoryImpl(
    private val apiProvider: WorksNetworkDataSource
) : WorkListRepository {
    override fun search(query: String): Flow<PagingData<Works>> {
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE_SIZE,
                prefetchDistance = DEFAULT_PREFETCH_DISTANCE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = {
                WorksPagingSource(
                    apiProvider = apiProvider,
                    query = query
                )
            }
        ).flow
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 15
        private const val DEFAULT_PREFETCH_DISTANCE = 5
    }
}