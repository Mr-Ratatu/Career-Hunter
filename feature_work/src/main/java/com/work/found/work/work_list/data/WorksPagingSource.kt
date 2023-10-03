package com.work.found.work.work_list.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.work.found.core.api.model.work.Works
import com.work.found.core.api.network_service.WorksNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.lang.Integer.max
import kotlin.coroutines.suspendCoroutine

private const val STARTING_KEY = 1

class WorksPagingSource(
    private val apiProvider: WorksNetworkDataSource,
    private val query: String,
) : PagingSource<Int, Works>() {

    override fun getRefreshKey(state: PagingState<Int, Works>): Int? {
        val anchorPosition = state.anchorPosition ?: STARTING_KEY
        return state.closestPageToPosition(anchorPosition)?.run {
            prevKey?.inc() ?: nextKey?.dec()
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Works> = coroutineScope {
        val pageNumber = params.key ?: STARTING_KEY
        val response = async(Dispatchers.IO) { apiProvider.fetchWorkList(query, pageNumber) }

        return@coroutineScope runCatching {
            response.await()
        }.fold(
            onSuccess = { symbolPage ->
                LoadResult.Page(
                    data = symbolPage.works,
                    prevKey = PagingKeyEntity.getPrevKey(pageNumber, params.loadSize),
                    nextKey = PagingKeyEntity.getNextKey(symbolPage.currentPage)
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }

    private object PagingKeyEntity {
        fun getNextKey(lastPosition: Int): Int = lastPosition.inc()

        fun getPrevKey(position: Int, loadSize: Int): Int? {
            return when (val prevKey = ensureValidKey(position - loadSize)) {
                STARTING_KEY -> null
                else -> prevKey
            }
        }

        /**
         * Makes sure the paging key is never less than [STARTING_KEY]
         */
        private fun ensureValidKey(key: Int) = max(STARTING_KEY, key)
    }

}