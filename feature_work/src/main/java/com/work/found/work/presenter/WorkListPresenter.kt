package com.work.found.work.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.work.interactor.WorkListInteractorInput
import com.work.found.work.provider.WorkListViewStateImpl
import com.work.found.work.provider.WorkListViewStateInput
import com.work.found.work.view.WorkListViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class WorkListPresenter : BasePresenter<WorkListViewStateInput>(), WorkListViewOutput {

    @Inject
    lateinit var interactor: WorkListInteractorInput

    init {
        presenterScope.launch(Dispatchers.IO) {
            interactor.fetchWorkList {
                viewState.setWorkList(Unit)
            }
        }
    }

    override fun initDagger() {

    }

    override fun provideViewState(): ViewState<*> {
        return WorkListViewStateImpl()
    }
}