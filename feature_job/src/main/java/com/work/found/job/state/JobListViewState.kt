package com.work.found.job.state

import com.work.found.core.base.state.ViewState

class JobListViewStateImpl : JobListViewStateInput {

    override val dataProvider = JobListDataProviderImpl()
}

interface JobListViewStateInput : ViewState<JobListDataProviderInput> {

}