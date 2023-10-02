package com.work.found.work.work_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.model.work.Works
import com.work.found.core.api.state.Result
import com.work.found.work.work_list.domain.WorkListInteractorInput
import com.work.found.work.work_list.domain.WorkListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WorkListViewModel(
    private val interactor: WorkListInteractorInput,
    connectionInteractor: NetworkConnectionInteractor,
    val useCase: WorkListUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<Result<WorkResponse>>(Result.Loading)
    val state = _state.asStateFlow()

    private val _articles = MutableStateFlow<List<ArticlesItem>>(emptyList())
    val articles = _articles.asStateFlow()

    val pagingData: Flow<PagingData<Works>>

    init {
        pagingData = connectionInteractor.isNetworkConnectedCallback
            .filter { it }
            .flatMapLatest {
                useCase.invoke("Android")
            }
            .cachedIn(viewModelScope)
    }

    private fun loadWorkList() = viewModelScope.launch(Dispatchers.IO) {
        val workList = interactor.fetchWorkList(vacanciesName = "Android")
        val articlesList = interactor.loadArticles()
        _state.value = workList
        _articles.value = articlesList
    }

    fun onReloadData() = loadWorkList()
}