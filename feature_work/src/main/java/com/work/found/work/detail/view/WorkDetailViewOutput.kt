package com.work.found.work.detail.view

import com.work.found.core.base.presentation.ViewOutput

interface WorkDetailViewOutput: ViewOutput {
    fun onUpdateDetailInfo(id: String)
}