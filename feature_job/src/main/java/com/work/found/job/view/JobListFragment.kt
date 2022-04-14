package com.work.found.job.view

import android.os.Bundle
import android.view.View
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.job.R
import com.work.found.job.presenter.JobListPresenter

class JobListFragment: BaseFragment<JobListViewOutput>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override val layoutId: Int = R.layout.fragment_job_list

    override fun initViewOutput(): JobListViewOutput = JobListPresenter()

    override fun initDagger() {
    }

    override fun initView() {
    }

    override fun subscribeOnData() {
    }

    override fun setInsetListener(rootView: View) = Unit

}