package com.work.found.work.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.work.found.core.base.extensions.launchWhenStarted
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.work.R
import com.work.found.work.presenter.WorkListPresenter
import com.work.found.work.provider.WorkListDataProvider

class WorkListFragment : BaseFragment<WorkListViewOutput, WorkListDataProvider>() {

    companion object {
        fun newInstance(): WorkListFragment {
            return WorkListFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override val layoutId: Int = R.layout.fragment_work_list

    override fun initViewOutput(): WorkListViewOutput = WorkListPresenter()

    override fun initView() {
    }

    override fun subscribeOnData() {
        with(dataProvider) {
            workListValues.launchWhenStarted(lifecycleScope) {
                // TODO in AN-02
            }
        }
    }

    override fun setInsetListener(rootView: View) = Unit

}