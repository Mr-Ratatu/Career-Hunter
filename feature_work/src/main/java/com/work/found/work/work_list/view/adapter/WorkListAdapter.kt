package com.work.found.work.work_list.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import com.work.found.core.api.model.work.Works
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.diffUtilCallback
import com.work.found.core.base.extensions.layoutInflater
import com.work.found.core.base.extensions.setHtmlText
import com.work.found.core.base.presentation.BaseViewHolder
import com.work.found.core.base.utils.Constants.UNDEFINED
import com.work.found.core.base.utils.RangeController
import com.work.found.work.R

class WorkListAdapter(
    private val onClickItem: (id: String) -> Unit,
    private val onApplyWork: () -> Unit
) : PagingDataAdapter<Works, WorkListAdapter.WorkListViewHolder>(
    diffUtilCallback(
        areItemsTheSame = { oldItem, newItem ->
            oldItem.id == newItem.id
        },
        areContentsTheSame = { oldItem, newItem ->
            oldItem == newItem
        }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkListViewHolder {
        return WorkListViewHolder(parent.layoutInflater(R.layout.item_work))
    }

    override fun onBindViewHolder(holder: WorkListViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }

    override fun onViewAttachedToWindow(holder: WorkListViewHolder) {
        val position = holder.adapterPosition
        if (position != UNDEFINED) {
            holder.apply {
                itemView.setOnClickListener {
                    val workId = getItem(position)?.id.orEmpty()
                    onClickItem.invoke(workId)
                }

                applyJob { setOnClickListener { onApplyWork() } }
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: WorkListViewHolder) {
        holder.apply {
            itemView.setOnClickListener(null)
            applyJob { setOnClickListener(null) }
        }
    }

    class WorkListViewHolder(itemView: View) : BaseViewHolder<Works>(itemView) {

        private val name = itemView.contentView<TextView>(R.id.work_tv_name)
        private val salary = itemView.contentView<TextView>(R.id.work_tv_salary)
        private val companyName = itemView.contentView<TextView>(R.id.work_tv_company_name)
        private val location = itemView.contentView<TextView>(R.id.work_tv_location)
        private val description = itemView.contentView<TextView>(R.id.work_tv_description)
        val applyJob = itemView.contentView<Button>(R.id.work_btn_apply_job)

        override fun bind(item: Works) {
            name { text = item.name }
            companyName { text = item.employer.name }
            location { text = item.area.name }
            description {
                val description = item.snippet?.responsibility
                setHtmlText(description)
                isVisible = !description.isNullOrEmpty()
            }
            salary {
                text = RangeController.getRangeSalary(
                    from = item.salary?.from,
                    to = item.salary?.to,
                    currency = item.salary?.currency,
                    defaultMessage = R.string.income_not_specified
                )
            }
        }
    }
}