package com.work.found.core.base.presentation

internal interface OnBackPressedListener {

    fun onBackPressed(callback: () -> Unit)
}