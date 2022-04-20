package com.work.found.core.base.extensions

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.fragment.app.Fragment
import com.work.found.core.base.presentation.ContentView

fun <T : View> Fragment.contentView(viewId: Int) = ContentView<T>(viewId, this)

fun <T : View> View.contentView(viewId: Int) = ContentView<T>(viewId, this)

fun <T : View> Activity.contentView(viewId: Int) = ContentView<T>(viewId, this)

fun <T : View> Dialog.contentView(viewId: Int) = ContentView<T>(viewId, this)