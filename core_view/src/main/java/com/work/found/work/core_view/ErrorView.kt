package com.work.found.work.core_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.work.found.work.core_view.databinding.LayoutErrorBinding

class ErrorView constructor(context: Context, attr: AttributeSet?) : FrameLayout(context, attr) {

    private var binding: LayoutErrorBinding

    init {
        binding = LayoutErrorBinding.inflate(LayoutInflater.from(context))
    }

    fun setOnReloadClickListener(action: () -> Unit) {
        binding.replayBtn.setOnClickListener { action() }
    }
}