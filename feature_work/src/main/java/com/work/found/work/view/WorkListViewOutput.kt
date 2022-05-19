package com.work.found.work.view

import com.work.found.core.base.presentation.ViewOutput

interface WorkListViewOutput: ViewOutput {
    fun showDetailInfoAboutVacancy(id: String)
    fun showDetailInfoAboutArticles(id: Int)
}