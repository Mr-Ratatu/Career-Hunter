package com.work.found.job.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.job.state.JobListViewStateImpl
import com.work.found.job.state.JobListViewStateInput
import com.work.found.job.view.JobListViewOutput

class JobListPresenter : BasePresenter<JobListViewStateInput>(), JobListViewOutput {

    override fun provideViewState(): ViewState<*> {
        return JobListViewStateImpl()
    }
}