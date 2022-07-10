package com.work.found.core.base.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun Fragment.hideKeyboard() = requireView().hideKeyboard()

fun Fragment.showKeyboard() = requireView().showKeyboard()

fun Fragment.popBackStack() = parentFragmentManager.popBackStack()

fun Fragment.delayWithScope(duration: Long) {
    lifecycleScope.launch {
        delay(duration)
    }
}