package com.work.found.splash.router

import androidx.fragment.app.FragmentManager
import com.work.found.routing.base.Animation
import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl
import com.work.found.routing.modules.HomeRoutingModule

class SplashRouter : SplashRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openHomeScreen(manager: FragmentManager) {
        addFragmentToRoot(
            clazz = HomeRoutingModule::class,
            fragmentManager = manager,
            isReplace = true,
            animation = Animation.noAnimation(),
        )
    }
}