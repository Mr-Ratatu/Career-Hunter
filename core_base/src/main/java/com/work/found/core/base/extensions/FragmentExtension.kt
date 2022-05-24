package com.work.found.core.base.extensions

import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() = requireView().hideKeyboard()

fun Fragment.showKeyboard() = requireView().showKeyboard()

fun Fragment.popBackStack() = parentFragmentManager.popBackStack()