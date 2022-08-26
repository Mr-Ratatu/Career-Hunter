package com.work.found.work.work_list.view

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.work.R
import com.work.found.work.core_view.ErrorView
import com.work.found.work.core_view.States
import com.work.found.work.core_view.StatesView
import com.work.found.work.work_list.presenter.WorkListPresenter
import com.work.found.work.work_list.provider.WorkListDataProvider
import com.work.found.work.work_list.view.adapter.ArticlesListAdapter
import com.work.found.work.work_list.view.adapter.WorkListAdapter

class WorkListFragment : BaseFragment<WorkListViewOutput, WorkListDataProvider>() {

    companion object {
        fun newInstance(): WorkListFragment {
            return WorkListFragment()
        }
    }

    private val stateView = contentView<StatesView>(R.id.work_list_sv_states)
    private val skeleton = contentView<View>(R.id.work_list_vs_skeleton)
    private val workList = contentView<RecyclerView>(R.id.work_list_rv)
    private val searchField = contentView<LinearLayout>(R.id.work_list_ll_search_container)
    private val filterBtn = contentView<ImageView>(R.id.work_list_iv_filter_btn)
    private val errorView = contentView<ErrorView>(R.id.error_view)
    private val shadow = contentView<View>(R.id.work_list_shadow)

    // Adapters
    private val articleListAdapter = ArticlesListAdapter(
        itemOnClick = { id -> viewOutput.showDetailInfoAboutArticles(id, parentFragmentManager) }
    )
    private val workListAdapter = WorkListAdapter(
        onClickItem = { id -> viewOutput.showDetailInfoAboutVacancy(id, parentFragmentManager) },
        onApplyWork = { viewOutput.showAuthScreen(parentFragmentManager) }
    )
    private val concatAdapter = ConcatAdapter(articleListAdapter, workListAdapter)

    private val shadowDelegate = ShadowDelegate()

    override val layoutId: Int = R.layout.fragment_work_list

    override fun initViewOutput(): WorkListViewOutput = WorkListPresenter()

    override fun initView() {
        stateView {
            setCoroutineScope(lifecycleScope)
        }

        workList {
            adapter = concatAdapter
        }

        searchField {
            setOnClickListener { viewOutput.showSearchScreen(parentFragmentManager) }
        }

        filterBtn {
            setOnClickListener { viewOutput.showFilterScreen() }
        }

        shadowDelegate.setShadowScrollListener(
            scrollView = workList.view,
            shadowView = shadow.view
        )

        errorView {
            setOnReloadClickListener { viewOutput.onReloadData() }
        }
    }

    override fun subscribeOnData() {
        with(dataProvider) {
            states.launchWhenStartedWithScope { state ->
                handleStates(state)
            }

            articlesValue.launchWhenStartedWithScope { articles ->
                articleListAdapter.setArticles(articles)
            }
        }
    }

    private fun handleStates(result: Result<WorkResponse>) {
        when (result) {
            is Result.Success -> {
                stateView { updateState(States.SUCCESS) }
                workListAdapter.submitList(result.value.items)
                errorView { visibility = View.GONE }
                hideSkeleton()
            }
            is Result.Loading -> {
                showSkeleton()
                stateView { updateState(States.LOADING) }
            }
            is Result.Error,
            is Result.NotFoundError,
            is Result.ConnectionError -> {
                stateView { updateState(States.ERROR) }
                skeleton { visibility = View.GONE }
                errorView { visibility = View.VISIBLE }
            }
        }
    }

    private fun showSkeleton() {
        skeleton { visibility = View.VISIBLE }
        workList { visibility = View.GONE }
    }

    private fun hideSkeleton() {
        skeleton { visibility = View.GONE }
        workList { visibility = View.VISIBLE }
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }

}