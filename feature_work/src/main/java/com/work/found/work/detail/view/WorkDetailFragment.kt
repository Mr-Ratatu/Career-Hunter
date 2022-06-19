package com.work.found.work.detail.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import coil.load
import com.work.found.core.api.model.detail.WorkDetailResponse
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.popBackStack
import com.work.found.core.base.extensions.setHtmlText
import com.work.found.core.base.extensions.textPlaceHolder
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.Constants
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.work.R
import com.work.found.work.core_view.StatesView
import com.work.found.work.detail.presetner.WorkDetailPresenter
import com.work.found.work.detail.provider.WorkDetailDataProviderInput

class WorkDetailFragment : BaseFragment<WorkDetailViewOutput, WorkDetailDataProviderInput>() {

    companion object {
        private const val ARGUMENT_ID = "id"

        fun newInstance(
            id: String
        ): WorkDetailFragment {
            val arguments = Bundle().apply {
                putString(ARGUMENT_ID, id)
            }
            return WorkDetailFragment().apply { setArguments(arguments) }
        }
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

    private val shadowDelegate = ShadowDelegate()

    override val layoutId: Int = R.layout.fragment_work_detail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = requireArguments().getString(ARGUMENT_ID) ?: ""
        viewOutput.onUpdateDetailInfo(id)

        showSkeleton()
    }

    override fun initViewOutput(): WorkDetailViewOutput {
        return WorkDetailPresenter()
    }

    override fun initView() {
        toolbar {
            setNavigationOnClickListener {
                popBackStack()
            }
        }

        shadowDelegate.setShadowScrollListener(
            scrollView = scrollContainer.view,
            shadowView = toolbar.view
        )

        stateView {
            setCoroutineScope(lifecycleScope)
        }
    }

    override fun subscribeOnData() {
        dataProvider.apply {
            detailInfo.observe(this@WorkDetailFragment) { response ->
                initContent(response)
            }

            states.observe(this@WorkDetailFragment) { state ->
                stateView { updateState(state) }
            }
        }
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
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
        companyLogo { load(response.employer.logo_urls.mediumIcon) }
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
            else -> Constants.EMPTY_STRING
        }

        text = rangeSalary
    }
}