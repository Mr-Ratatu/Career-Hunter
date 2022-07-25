package com.work.found.root.root_activity.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface RootViewOutput: ViewOutput {
    fun onShowSplashScreen(manager: FragmentManager)
    fun onShowHomeScreen(manager: FragmentManager)
}