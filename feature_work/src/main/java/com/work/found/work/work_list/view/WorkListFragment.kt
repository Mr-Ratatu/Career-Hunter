package com.work.found.work.work_list.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.model.work.WorkResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.extensions.launchWhenStarted
import com.work.found.core.base.extensions.viewModels
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.core_view.States
import com.work.found.work.databinding.FragmentWorkListBinding
import com.work.found.work.work_list.WorkListViewModel
import com.work.found.work.work_list.di.DaggerWorkListComponent
import com.work.found.work.work_list.di.constructWorkListViewModel
import com.work.found.work.work_list.router.WorkListRouterInput
import com.work.found.work.work_list.view.adapter.ArticlesListAdapter
import com.work.found.work.work_list.view.adapter.WorkListAdapter
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class WorkListFragment : Fragment() {

    @Inject
    lateinit var router: WorkListRouterInput

    private val component by lazy {
        DaggerWorkListComponent
            .builder()
            .coroutineScope(lifecycleScope)
            .dependencies(DaggerInjector.appDependencies())
            .build()
    }

    private lateinit var binding: FragmentWorkListBinding

    private val viewModel: WorkListViewModel by viewModels {
        component.constructWorkListViewModel()
    }

    // Adapters
    private val articleListAdapter = ArticlesListAdapter(
        itemOnClick = { id -> router.openArticleScreen(parentFragmentManager, id) }
    )
    private val workListAdapter = WorkListAdapter(
        onClickItem = { id -> router.openWorkDetailScreen(parentFragmentManager, id) },
        onApplyWork = { router.openAuthScreen(parentFragmentManager) }
    )
    private val concatAdapter = ConcatAdapter(articleListAdapter, workListAdapter)

    private val shadowDelegate = ShadowDelegate()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkListBinding.inflate(inflater, container, false)

        initView()
        setInsetListener(binding.root)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        subscribeOnData()
    }

    private fun initView() {
        binding.apply {
            workListRv.adapter = concatAdapter
            workListHeader.workListLlSearchContainer.setOnClickListener {
                router.openSearchScreen(parentFragmentManager)
            }
            errorView.setOnReloadClickListener { viewModel.onReloadData() }
            shadowDelegate.setShadowScrollListener(
                scrollView = workListRv,
                shadowView = workListShadow
            )
        }
    }

    private fun subscribeOnData() {
//        combine(
//            flow = viewModel.state,
//            flow2 = viewModel.articles,
//            transform = ::handleStates,
//        ).launchWhenStarted(lifecycleScope)

        viewModel.pagingData.launchWhenStarted(lifecycleScope, workListAdapter::submitData)
    }

    private fun handleStates(result: Result<WorkResponse>, articlesItems: List<ArticlesItem>) {
        when (result) {
            is Result.Success -> {
                binding.workListSvStates.updateState(States.SUCCESS)
//                workListAdapter.submitList(result.value.items)
                articleListAdapter.setArticles(articlesItems)
                binding.errorView.visibility = View.GONE
                hideSkeleton()
            }
            is Result.Loading -> {
                showSkeleton()
                binding.workListSvStates.updateState(States.LOADING)
            }
            is Result.Error,
            is Result.NotFoundError,
            is Result.ConnectionError -> {
                binding.workListSvStates.updateState(States.ERROR)
                binding.workListVsSkeleton.root.visibility = View.GONE
                binding.errorView.visibility = View.VISIBLE
            }
        }
    }

    private fun showSkeleton() {
        binding.workListVsSkeleton.root.visibility = View.VISIBLE
        binding.workListRv.visibility = View.GONE
    }

    private fun hideSkeleton() {
        binding.workListVsSkeleton.root.visibility = View.GONE
        binding.workListRv.visibility = View.VISIBLE
    }

    private fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }

    companion object {
        private fun getHandledState(result: Result<WorkResponse>): States = when (result) {
            is Result.Success -> States.SUCCESS
            is Result.Loading -> States.LOADING
            is Result.Error,
            is Result.NotFoundError,
            is Result.ConnectionError -> States.ERROR
        }
    }
}