package com.work.found.core.base.utils

import android.view.View

interface VisibilityUi {

    fun apply(view: View)

    abstract class Base(private val visibility: Int) : VisibilityUi {
        override fun apply(view: View) {
            view.visibility = visibility
        }
    }

    object Visible : Base(View.VISIBLE)

    object Hide : Base(View.GONE)
}