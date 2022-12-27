package com.work.found.work.work_list.router

import androidx.fragment.app.FragmentManager

interface WorkListRouterInput {
    fun openWorkDetailScreen(manager: FragmentManager, id: String)
    fun openSearchScreen(manager: FragmentManager)
    fun openAuthScreen(manager: FragmentManager)
    fun openArticleScreen(manager: FragmentManager, id: Int)
}