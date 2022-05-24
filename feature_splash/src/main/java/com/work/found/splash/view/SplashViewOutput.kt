package com.work.found.splash.view

import androidx.fragment.app.FragmentManager
import com.work.found.core.base.presentation.ViewOutput

interface SplashViewOutput: ViewOutput {
    fun openWorkListScreen(manager: FragmentManager)
}