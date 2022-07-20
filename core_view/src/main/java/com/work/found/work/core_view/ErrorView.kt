package com.work.found.work.core_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import com.work.found.core.base.extensions.contentView

class ErrorView constructor(context: Context, attr: AttributeSet?) : FrameLayout(context, attr) {

    private val replayBtn = contentView<Button>(R.id.replay_btn)

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_error, this)
    }

    fun setOnReloadClickListener(action: () -> Unit) {
        replayBtn {
            setOnClickListener { action() }
        }
    }
}