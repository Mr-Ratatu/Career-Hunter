package com.work.found.root.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface RootViewOutput: ViewOutput {
    fun showSplashScreen(manager: FragmentManager)
}