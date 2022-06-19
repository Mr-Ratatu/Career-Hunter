package com.work.found.core.base.utils

import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.work.found.core.base.extensions.takeAs

class ViewInsetsController private constructor(
    private val forLeft: Boolean,
    private val forTop: Boolean,
    private val forRight: Boolean,
    private val forBottom: Boolean,
    private val usePadding: Boolean,
) : OnApplyWindowInsetsListener {
    companion object {
        var typeMask = WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime()
            @VisibleForTesting(otherwise = VisibleForTesting.NONE) set


        fun bindPadding(
            view: View,
            forLeft: Boolean = false,
            forTop: Boolean = false,
            forRight: Boolean = false,
            forBottom: Boolean = false,
        ) {
            require(forLeft || forTop || forRight || forBottom)
            val controller = ViewInsetsController(
                forLeft,
                forTop,
                forRight,
                forBottom,
                usePadding = true,
            )
            ViewCompat.setOnApplyWindowInsetsListener(view, controller)
        }

        fun bindMargin(
            view: View,
            forLeft: Boolean = false,
            forTop: Boolean = false,
            forRight: Boolean = false,
            forBottom: Boolean = false,
        ) {
            require(forLeft || forTop || forRight || forBottom)
            val controller = ViewInsetsController(
                forLeft,
                forTop,
                forRight,
                forBottom,
                usePadding = false,
            )
            ViewCompat.setOnApplyWindowInsetsListener(view, controller)
        }

        fun bindPaddingPerimeter(view: View) {
            val controller = ViewInsetsController(
                forLeft = true,
                forTop = true,
                forRight = true,
                forBottom = true,
                usePadding = true,
            )
            ViewCompat.setOnApplyWindowInsetsListener(view, controller)
        }

        fun bindMarginPerimeter(view: View) {
            val controller = ViewInsetsController(
                forLeft = true,
                forTop = true,
                forRight = true,
                forBottom = true,
                usePadding = false,
            )
            ViewCompat.setOnApplyWindowInsetsListener(view, controller)
        }
    }

    private var systemPaddingStart = 0
    private var systemPaddingTop = 0
    private var systemPaddingEnd = 0
    private var systemPaddingBottom = 0

    override fun onApplyWindowInsets(
        view: View,
        windowInsets: WindowInsetsCompat
    ): WindowInsetsCompat {
        when {
            usePadding -> view.updatePadding(windowInsets)
            else -> view.updateMargin(windowInsets)
        }
        return WindowInsetsCompat.CONSUMED
    }

    private fun View.updatePadding(windowInsets: WindowInsetsCompat) {
        val insets = windowInsets.getInsets(typeMask)
        var start = paddingStart
        if (forLeft) {
            start += insets.left - systemPaddingStart
            systemPaddingStart = insets.left
        }
        var top = paddingTop
        if (forTop) {
            top += insets.top - systemPaddingTop
            systemPaddingTop = insets.top
        }
        var end = paddingEnd
        if (forRight) {
            end += insets.right - systemPaddingEnd
            systemPaddingEnd = insets.right
        }
        var bottom = paddingBottom
        if (forBottom) {
            bottom += insets.bottom - systemPaddingBottom
            systemPaddingBottom = insets.bottom
        }
        val needUpdate =
            start != paddingStart || top != paddingTop || end != paddingEnd || bottom != paddingBottom
        if (needUpdate) {
            setPaddingRelative(start, top, end, bottom)
        }
    }

    private fun View.updateMargin(windowInsets: WindowInsetsCompat) {
        layoutParams.takeAs<ViewGroup.MarginLayoutParams>().run {
            val insets = windowInsets.getInsets(typeMask)
            var start = marginStart
            if (forLeft) {
                start += insets.left - systemPaddingStart
                systemPaddingStart = insets.left
            }
            var top = topMargin
            if (forTop) {
                top += insets.top - systemPaddingTop
                systemPaddingTop = insets.top
            }
            var end = marginEnd
            if (forRight) {
                end += insets.right - systemPaddingEnd
                systemPaddingEnd = insets.right
            }
            var bottom = bottomMargin
            if (forBottom) {
                bottom += insets.bottom - systemPaddingBottom
                systemPaddingBottom = insets.bottom
            }
            val needUpdate =
                marginStart != start || topMargin != top || marginEnd != end || bottomMargin != bottom
            if (needUpdate) {
                marginStart = start
                topMargin = top
                marginEnd = end
                bottomMargin = bottom
                layoutParams = this
            }
        }
    }
}