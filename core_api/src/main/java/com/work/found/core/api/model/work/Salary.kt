package com.work.found.core.api.model.work

data class Salary(
    val currency: String?,
    val from: Int,
    val gross: Boolean,
    val to: Any
)