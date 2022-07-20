package com.work.found.core.base.utils

import androidx.annotation.StringRes

class RangeController {

    companion object {
        fun getRangeSalary(
            from: Int?,
            to: Int?,
            currency: String?,
            @StringRes defaultMessage: Int
        ): String {
            val rangeSalary = when {
                from != null && to != null && currency != null -> {
                    "$from-$to $currency"
                }
                from == null || to == null || currency == null -> {
                   AppConfig.application.getString(defaultMessage)
                }
                else -> Constants.EMPTY_STRING
            }

            return rangeSalary
        }
    }
}