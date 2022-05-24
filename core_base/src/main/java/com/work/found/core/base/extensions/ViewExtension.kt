package com.work.found.core.base.extensions

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.TooltipCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun View.showKeyboard() {
    (this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
        .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun PopupMenu.showWithIcon() {
    val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
    fieldMPopup.isAccessible = true
    val mPopup = fieldMPopup.get(this)
    mPopup.javaClass
        .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
        .invoke(mPopup, true)

    show()
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View = layoutInflater().inflate(
    layoutRes,
    this,
    false
)

fun ViewGroup.layoutInflater(): LayoutInflater {
    return LayoutInflater.from(context)
}

fun ViewGroup.layoutInflater(
    @LayoutRes resource: Int,
    attachToRoot: Boolean = false
): View {
    return LayoutInflater.from(context).inflate(resource, this, attachToRoot)
}

@ExperimentalCoroutinesApi
fun View.clicksAsFlow() = callbackFlow {
    setOnClickListener {
        offer(Unit)
    }
    awaitClose {
        setOnClickListener(null)
    }
}

@FlowPreview
@ExperimentalCoroutinesApi
fun View.throttleAfterFirstClicks(coroutineScope: CoroutineScope, listener: () -> Unit) {
    coroutineScope.launch {
        clicksAsFlow().throttleAfterFirst(1000L).collect { listener() }
    }
}

fun View.setTooltip(@StringRes tooltipText: Int) {
    TooltipCompat.setTooltipText(this, context.getString(tooltipText))
}

fun TextView.textPlaceHolder(@StringRes strRes: Int, value: Int): String {
    return String.format(resources.getString(strRes), value)
}

fun ImageView.setImageFromString(imageName: String, type: String = "drawable") {
    val imageId = context.resources.getIdentifier(imageName, type, context.packageName)
    setImageResource(imageId)
}