package com.work.found.splash.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.SplashRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.splash.view.SplashFragment
import javax.inject.Inject

class SplashRouter : SplashRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun showSplashScreen(manager: FragmentManager) {
        addFragment(
            fragment = SplashFragment.newInstance(),
            fragmentManager = manager,
        )
    }
}