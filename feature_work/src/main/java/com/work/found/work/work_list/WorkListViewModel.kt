package com.work.found.work.work_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.model.work.Works
import com.work.found.work.articles.api.domain.ArticlesListUseCase
import com.work.found.work.articles.api.model.ArticlesItem
import com.work.found.work.work_list.domain.WorkListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn

class WorkListViewModel(
    connectionInteractor: NetworkConnectionInteractor,
    workListUseCase: WorkListUseCase,
    private val articlesListUseCase: ArticlesListUseCase,
) : ViewModel() {

    private val _articles = MutableStateFlow<List<ArticlesItem>>(emptyList())
    val articles = _articles.asStateFlow()

    private val _pagingData = MutableStateFlow<WorksItem?>(null)
    val pagingData = _pagingData.asStateFlow()

    init {
        combine(
            flow = connectionInteractor.isNetworkConnectedCallback,
            flow2 = flow { emit(articlesListUseCase()) },
            flow3 = workListUseCase.invoke("Android"),
            transform = { isConnected, articles, works ->
                if (isConnected)
                    _pagingData.value = WorksItem(
                        works = works,
                        articlesItem = articles
                    )
            }
        ).launchIn(viewModelScope)
    }
}

data class WorksItem(
    val works: PagingData<Works>,
    val articlesItem: List<ArticlesItem>
)