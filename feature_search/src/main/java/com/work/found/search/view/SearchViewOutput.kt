package com.work.found.search.view

import com.work.found.core.base.presentation.ViewOutput

interface SearchViewOutput: ViewOutput {

    fun onFetchWorkList(name: String)
}