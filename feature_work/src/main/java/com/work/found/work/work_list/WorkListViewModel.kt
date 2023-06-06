package com.work.found.work.work_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class WorkListViewModel(
    private val interactor: WorkListInteractorInput,
    private val connectionInteractor: NetworkConnectionInteractor
) : ViewModel() {

    private val _state = MutableStateFlow<Result<WorkResponse>>(Result.Loading)
    val state = _state.asStateFlow()

    private val _articles = MutableStateFlow<List<ArticlesItem>>(emptyList())
    val articles = _articles.asStateFlow()

    init {
        connectionInteractor
            .isNetworkConnectedCallback
            .onEach { isConnected ->
                if (isConnected) loadWorkList()
            }
            .launchIn(viewModelScope)
    }

    private fun loadWorkList() = viewModelScope.launch(Dispatchers.IO) {
        val workList = interactor.fetchWorkList(vacanciesName = "Android")
        val articlesList = interactor.loadArticles()
        _state.value = workList
        _articles.value = articlesList
    }

    fun onReloadData() = loadWorkList()
}