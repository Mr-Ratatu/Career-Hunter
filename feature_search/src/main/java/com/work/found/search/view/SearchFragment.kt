package com.work.found.search.view

import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.extensions.*
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.Constants
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.search.R
import com.work.found.search.presenter.SearchPresenter
import com.work.found.search.provider.SearchDataProvider

class SearchFragment : BaseFragment<SearchViewOutput, SearchDataProvider>() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val toolbar = contentView<Toolbar>(R.id.search_tb)
    private val searchField = contentView<EditText>(R.id.search_field_ed)
    private val workList = contentView<RecyclerView>(R.id.search_work_list_rv)
    private val shadow = contentView<View>(R.id.search_work_shadow)

    private val shadowDelegate = ShadowDelegate()
    private val searchAdapter = SearchAdapter(
        onClickItem = { id -> viewOutput.showDetailInfoAboutWork(id, parentFragmentManager) }
    )

    override val layoutId: Int = R.layout.fragment_search

    override fun initViewOutput(): SearchViewOutput {
        return SearchPresenter()
    }

    override fun <T : LifecycleOwner> onHideView(view: T) {
        super.onHideView(view)
        hideKeyboard()
    }

    override fun initView() {
        toolbar {
            setNavigationOnClickListener { popBackStack() }
        }

        searchField {
            showKeyboard()
            addTextChangedListener { name ->
                delayWithScope(Constants.ONE_SECOND)
                viewOutput.onFetchWorkList(name.toString())
            }
        }

        workList {
            adapter = searchAdapter
        }

        shadowDelegate.setShadowScrollListener(
            scrollView = workList.view,
            shadowView = shadow.view
        )
    }

    override fun subscribeOnData() {
        dataProvider.apply {
            states.observeWithViewScopeIgnoreNull { response ->
                handleStates(response)
            }
        }
    }

    private fun handleStates(result: Result<WorkResponse>) {
        when (result) {
            is Result.Success -> {
//                searchAdapter.submitList(result.value.items)
            }
            is Result.Loading -> Unit
            is Result.Error -> Unit
            is Result.NotFoundError -> Unit
            is Result.ConnectionError -> Unit
        }
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindPadding(rootView, forTop = true, forBottom = true)
    }
}