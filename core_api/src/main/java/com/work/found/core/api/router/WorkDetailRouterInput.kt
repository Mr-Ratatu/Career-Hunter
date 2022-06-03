package com.work.found.core.api.router

import androidx.fragment.app.FragmentManager

interface WorkDetailRouterInput {

    fun openWorkDetailScreen(id: String, manager: FragmentManager)
}