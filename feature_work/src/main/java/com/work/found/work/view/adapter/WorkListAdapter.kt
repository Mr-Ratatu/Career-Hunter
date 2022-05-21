package com.work.found.work.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import com.work.found.core.api.model.work.WorkDto
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.diffUtilCallback
import com.work.found.core.base.extensions.layoutInflater
import com.work.found.core.base.presentation.BaseViewHolder
import com.work.found.core.base.utils.Constants
import com.work.found.core.base.utils.Constants.UNDEFINED
import com.work.found.work.R

class WorkListAdapter(
    private val onClickItem: (id: String) -> Unit,
    private val onApplyWork: () -> Unit
) : ListAdapter<WorkDto, WorkListAdapter.WorkListViewHolder>(
    diffUtilCallback(
        areItemsTheSame = { oldItem, newItem ->
            oldItem == newItem
        },
        areContentsTheSame = { oldItem, newItem ->
            oldItem.id == newItem.id
        }
    )
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkListViewHolder {
        return WorkListViewHolder(parent.layoutInflater(R.layout.item_work))
    }

    override fun onBindViewHolder(holder: WorkListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun onViewAttachedToWindow(holder: WorkListViewHolder) {
        val position = holder.adapterPosition
        if (position != UNDEFINED) {
            holder.itemView.setOnClickListener {
                val workId = currentList[position].id
                onClickItem.invoke(workId)
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: WorkListViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

    class WorkListViewHolder(itemView: View) : BaseViewHolder<WorkDto>(itemView) {

        private val name = itemView.contentView<TextView>(R.id.work_tv_name)
        private val salary = itemView.contentView<TextView>(R.id.work_tv_salary)
        private val companyName = itemView.contentView<TextView>(R.id.work_tv_company_name)
        private val location = itemView.contentView<TextView>(R.id.work_tv_location)
        private val description = itemView.contentView<TextView>(R.id.work_tv_description)
        private val salaryIcon = itemView.contentView<ImageView>(R.id.work_iv_salary_icon)

        override fun bind(item: WorkDto) {
            name { text = item.name }
            companyName { text = item.employer.name }
            location { text = item.area.name }
            description {
                val description = item.snippet?.responsibility
                text = description
                isVisible = !description.isNullOrEmpty()
            }
            salary {
                text = getRangeSalary(
                    from = item.salary?.from,
                    to = item.salary?.to,
                    currency = item.salary?.currency
                )
            }
        }

        private fun getRangeSalary(from: Int?, to: Int?, currency: String?): String {
            val rangeSalary = when {
                from != null && to != null && currency != null -> { "$from-$to $currency" }
                from == null || to == null || currency == null -> {
                    salaryIcon { visibility = View.GONE }
                    Constants.EMPTY_STRING
                }
                else -> Constants.EMPTY_STRING
            }

            return rangeSalary
        }
    }
}