package com.work.found.search.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface SearchViewOutput: ViewOutput {

    fun onFetchWorkList(name: String)

    fun showDetailInfoAboutWork(id: String, manager: FragmentManager)
}