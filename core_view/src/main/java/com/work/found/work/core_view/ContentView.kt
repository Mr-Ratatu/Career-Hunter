package com.work.found.work.core_view

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import timber.log.Timber

class ContentView<T : View> private constructor(
    private val viewId: Int,
    private val context: Context?,
    private val dialog: Dialog? = null,
    private val activity: Activity? = null,
    private val fragment: Fragment? = null,
    private val baseView: View? = null,
) {

    constructor(viewId: Int, baseView: View) : this(viewId, baseView.context, baseView = baseView)

    constructor(viewId: Int, activity: Activity) : this(
        viewId,
        activity.baseContext,
        activity = activity
    )

    constructor(viewId: Int, fragment: Fragment) : this(
        viewId,
        fragment.context,
        fragment = fragment
    )

    constructor(viewId: Int, dialog: Dialog) : this(viewId, dialog.context, dialog = dialog)

    val view: T
        get() = when {
            dialog != null -> dialog.findViewById(viewId)
            activity != null -> activity.findViewById(viewId)
            fragment != null -> fragment.requireView().findViewById(viewId)
            baseView != null -> baseView.findViewById(viewId)
            else -> throw IllegalStateException("There is no initialized views")
        }

    val nullableView: T?
        get() {
            return when {
                dialog != null -> dialog.findViewById<View>(viewId).castToGenericType()
                activity != null -> activity.findViewById<View>(viewId).castToGenericType()
                fragment != null -> fragment.view?.findViewById<View>(viewId).castToGenericType()
                baseView != null -> baseView.findViewById<View>(viewId).castToGenericType()
                else -> throw IllegalStateException("There is no initialized views")
            }
        }

    inline operator fun invoke(body: T.() -> Unit) {
        nullableView?.apply(body)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : View> View?.castToGenericType(): T? {
        if (this == null) {
            val resourceName = context?.resources?.getResourceEntryName(viewId)
            Timber.w("View with id $resourceName is null")
            return null
        }

        try {
            this as T
        } catch (e: ClassCastException) {
            val resourceName = context?.resources?.getResourceEntryName(viewId)
            Timber.e("View with id $resourceName has invalid type. ${e.message}")
            return null
        }

        return this
    }
}