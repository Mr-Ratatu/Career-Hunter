package com.work.found.core.base.utils

import android.view.View
import androidx.core.view.isVisible

class ShadowDelegate {

    companion object {
        private const val UP = -1
    }

    fun setShadowScrollListener(scrollView: View, shadowView: View) {
        scrollView.setOnScrollChangeListener { _, _, _, _, _ ->
            shadowView.isVisible = scrollView.canScrollVertically(UP)
        }
    }
}