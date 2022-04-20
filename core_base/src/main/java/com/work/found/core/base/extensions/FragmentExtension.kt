package com.work.found.core.base.extensions

import androidx.fragment.app.Fragment
import com.work.found.core.api.di.AppWithFacade
import com.work.found.core.api.di.Dependencies

fun Fragment.createDependency(): Dependencies {
    return (requireActivity().application as AppWithFacade).getAppFacade()
}

fun Fragment.hideKeyboard() = requireView().hideKeyboard()

fun Fragment.showKeyboard() = requireView().showKeyboard()

fun Fragment.popBackStack() = parentFragmentManager.popBackStack()