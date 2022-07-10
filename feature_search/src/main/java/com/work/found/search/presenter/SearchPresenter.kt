package com.work.found.search.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.States
import com.work.found.core.di.base.DaggerInjector
import com.work.found.search.di.DaggerSearchComponent
import com.work.found.search.interactor.SearchInteractorInput
import com.work.found.search.provider.SearchViewState
import com.work.found.search.provider.SearchViewStateImpl
import com.work.found.search.view.SearchViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchPresenter : BasePresenter<SearchViewState>(), SearchViewOutput {

    @Inject
    lateinit var searchInteractor: SearchInteractorInput

    init {
        DaggerSearchComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun onFetchWorkList(name: String) {
        presenterScope.launch(Dispatchers.IO) {
            val response = searchInteractor.fetchWorkList(vacanciesName = name)

            withContext(Dispatchers.Main) {
                response
                    .onSuccess { work ->
                        viewState.updateWorkList(work)
                    }
                    .onFailure { error ->
                    }
            }
        }
    }

    override fun provideViewState(): ViewState<*> {
        return SearchViewStateImpl()
    }
}