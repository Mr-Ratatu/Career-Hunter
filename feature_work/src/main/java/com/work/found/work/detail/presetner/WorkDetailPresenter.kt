package com.work.found.work.detail.presetner

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.States
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.detail.di.DaggerWorkDetailComponent
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import com.work.found.work.detail.provider.WorkDetailViewStateImpl
import com.work.found.work.detail.provider.WorkDetailViewStateInput
import com.work.found.work.detail.view.WorkDetailViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkDetailPresenter : BasePresenter<WorkDetailViewStateInput>(), WorkDetailViewOutput {

    @Inject
    lateinit var workDetailInteractor: WorkDetailInteractorInput

    init {
        DaggerWorkDetailComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun provideViewState(): ViewState<*> {
        return WorkDetailViewStateImpl()
    }

    override fun onUpdateDetailInfo(id: String) {
        presenterScope.launch(Dispatchers.IO) {
            val response = workDetailInteractor.fetchWorkDetail(id)
            withContext(Dispatchers.Main) {
                response
                    .onSuccess { response ->
                        viewState.updateDetailInfo(response)
                        viewState.updateState(States.SUCCESS)
                    }
                    .onFailure { error ->
                        viewState.updateState(States.ERROR)
                    }
            }
        }
    }
}