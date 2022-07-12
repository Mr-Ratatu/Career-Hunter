package com.work.found.work.work_list.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface WorkListViewOutput: ViewOutput {
    fun showDetailInfoAboutVacancy(id: String, manager: FragmentManager)
    fun showDetailInfoAboutArticles(id: Int, manager: FragmentManager)
    fun showSearchScreen(manager: FragmentManager)
    fun showFilterScreen()
}