package com.work.found.work.detail.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.api.state.Result
import com.work.found.core.base.extensions.*
import com.work.found.core.base.utils.Constants.EMPTY_STRING
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.core.di.base.DaggerInjector
import com.work.found.routing.modules.WorkDetailRoutingModule
import com.work.found.work.R
import com.work.found.work.core_view.States
import com.work.found.work.core_view.StatesView
import com.work.found.work.detail.di.DaggerWorkDetailComponent
import com.work.found.work.detail.di.constructWorkDetailViewModel

class WorkDetailFragment : Fragment(R.layout.fragment_work_detail) {

    private val component by lazy {
        DaggerWorkDetailComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
    }

    private val viewModel by viewModels {
        component.constructWorkDetailViewModel(
            workId = requireArguments()
                .getString(WorkDetailRoutingModule.DETAIL_ID_KEY)
                .orElse { EMPTY_STRING }
        )
    }

    private val toolbar = contentView<Toolbar>(R.id.work_detail_tb)
    private val workName = contentView<TextView>(R.id.work_detail_tv_name)
    private val experience = contentView<TextView>(R.id.work_detail_tv_experience)
    private val salary = contentView<TextView>(R.id.work_detail_tv_salary)
    private val schedule = contentView<TextView>(R.id.work_detail_tv_schedule)
    private val companyLogo = contentView<ImageView>(R.id.work_detail_tv_logo)
    private val companyName = contentView<TextView>(R.id.work_detail_tv_company_name)
    private val address = contentView<TextView>(R.id.work_detail_tv_address)
    private val description = contentView<TextView>(R.id.work_detail_tv_description)
    private val scrollContainer = contentView<ScrollView>(R.id.work_detail_sv)
    private val stateView = contentView<StatesView>(R.id.work_detail_sv_states)
    private val skeleton = contentView<View>(R.id.work_detail_skeleton)
    private val shadow = contentView<View>(R.id.word_detail_shadow)

    private val shadowDelegate = ShadowDelegate()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInsetListener(view)
        initView()
        subscribeOnData()
        showSkeleton()
    }

    private fun initView() {
        toolbar {
            setNavigationOnClickListener {
                popBackStack()
            }
        }

        shadowDelegate.setShadowScrollListener(
            scrollView = scrollContainer.view,
            shadowView = shadow.view
        )
    }

    private fun subscribeOnData() {
        viewModel.state.launchWhenStarted(lifecycleScope) { state ->
            handleStates(state)
        }
    }

    private fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }

    private fun handleStates(result: Result<WorkDetailResponse>) {
        when (result) {
            is Result.Success -> {
                initContent(result.value)
                stateView { updateState(States.SUCCESS) }
            }
            is Result.Loading -> stateView { updateState(States.LOADING) }
            is Result.Error -> stateView { updateState(States.ERROR) }
            is Result.NotFoundError -> Unit
            is Result.ConnectionError -> Unit
        }
    }

    private fun initContent(response: WorkDetailResponse) {
        workName { text = response.name }
        salary {
            setRangeSalary(
                from = response.salary?.from,
                to = response.salary?.to,
                currency = response.salary?.currency
            )
        }
        experience {
            text = textPlaceHolder(
                R.string.experience_placeholder,
                response.experience.name
            )
        }
        schedule {
            text = textPlaceHolder(
                R.string.schedule_placeholder,
                response.schedule.name,
                response.employment.name
            )
        }
        companyLogo {
            val mediumLogo = response.employer.logo_urls.mediumIcon
            val original = response.employer.logo_urls.original
            load(
                when {
                    mediumLogo.isNullOrEmpty() -> original
                    else -> mediumLogo
                }
            )
        }
        companyName { text = response.employer.name }
        address { text = response.area.name }
        description { setHtmlText(response.description) }

        hideSkeleton()
    }

    private fun showSkeleton() {
        skeleton { visibility = View.VISIBLE }
    }

    private fun hideSkeleton() {
        skeleton { visibility = View.GONE }
    }

    private fun TextView.setRangeSalary(from: Int?, to: Int?, currency: String?) {
        val rangeSalary = when {
            from != null && to != null && currency != null -> {
                "$from-$to $currency"
            }
            from == null || to == null || currency == null -> {
                getString(R.string.income_not_specified)
            }
            else -> EMPTY_STRING
        }

        text = rangeSalary
    }
}