package com.work.found.core.api.model.work

data class Salary(
    val currency: String = "",
    val from: Int = 0,
    val gross: Boolean = false,
    val to: Int = 0
)