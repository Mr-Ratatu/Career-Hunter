package com.work.found.work.view

import android.view.View
import android.view.ViewStub
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.VisibilityUi
import com.work.found.work.R
import com.work.found.work.core_view.StatesView
import com.work.found.work.presenter.WorkListPresenter
import com.work.found.work.provider.WorkListDataProvider
import com.work.found.work.view.adapter.ArticlesAdapter
import com.work.found.work.view.adapter.WorkListAdapter

class WorkListFragment : BaseFragment<WorkListViewOutput, WorkListDataProvider>() {

    companion object {
        fun newInstance(): WorkListFragment {
            return WorkListFragment()
        }
    }

    private val stateView = contentView<StatesView>(R.id.work_list_sv_states)
    private val skeleton = contentView<ViewStub>(R.id.work_list_vs_skeleton)
    private val workList = contentView<RecyclerView>(R.id.work_list_rv)

    private val newsAdapter = ArticlesAdapter(
        onClickItem = { id -> viewOutput.showDetailInfoAboutArticles(id) }
    )
    private val workListAdapter = WorkListAdapter(
        onClickItem = { id -> viewOutput.showDetailInfoAboutVacancy(id) },
        onApplyWork = {}
    )
    private val concatAdapter = ConcatAdapter(newsAdapter, workListAdapter)

    override val layoutId: Int = R.layout.fragment_work_list

    override fun initViewOutput(): WorkListViewOutput = WorkListPresenter()

    override fun initView() {
        stateView {
            setCoroutineScope(lifecycleScope)
        }
        workList {
            adapter = concatAdapter
        }
    }

    override fun subscribeOnData() {
        with(dataProvider) {
            workListValues.observe(this@WorkListFragment) { work ->
                workListAdapter.submitList(work.items)
                stateView { updateState(StatesView.States.SUCCESS) }
            }

            errorValue.observe(this@WorkListFragment) { error ->
                stateView { updateState(StatesView.States.ERROR) }
            }

            loadingValue.observe(this@WorkListFragment) { isLoading ->
                stateView { updateState(StatesView.States.LOADING) }
                skeleton { isVisible = isLoading }
            }

            articlesValue.observe(this@WorkListFragment) { news ->
                newsAdapter.submitList(news)
            }
        }
    }

    override fun setInsetListener(rootView: View) = Unit

}