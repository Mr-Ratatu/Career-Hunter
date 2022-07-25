package com.work.found.root.home.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface HomeViewOutput: ViewOutput {
    fun onNavigationToWorkList(manager: FragmentManager)
}