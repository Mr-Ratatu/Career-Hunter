package com.work.found.search.router

import androidx.fragment.app.FragmentManager

interface SearchRouterInput {
    fun openWorkDetailScreen(manager: FragmentManager, id: String)
}