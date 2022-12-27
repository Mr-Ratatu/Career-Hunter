package com.work.found.root.root_activity.router

import androidx.fragment.app.FragmentManager
import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl
import com.work.found.routing.modules.SplashRoutingModule

class RootRouterImpl : RootRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openSplashScreen(manager: FragmentManager) {
        addFragmentToRoot(
            clazz = SplashRoutingModule::class,
            fragmentManager = manager,
        )
    }
}