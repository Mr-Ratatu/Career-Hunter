package com.work.found.work.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.state.Result
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WorkDetailViewModel(
    private val workId: String,
    private val interactor: WorkDetailInteractorInput,
) : ViewModel() {

    private val _state = MutableStateFlow<Result<WorkDetailResponse>>(Result.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = interactor.fetchWorkDetail(workId)
        }
    }
}