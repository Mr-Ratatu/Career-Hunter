package com.work.found.core.api.router

import androidx.fragment.app.FragmentManager

interface ArticlesRouterInput {

    fun showArticlesScreen(manager: FragmentManager, argumentId: Int)
}