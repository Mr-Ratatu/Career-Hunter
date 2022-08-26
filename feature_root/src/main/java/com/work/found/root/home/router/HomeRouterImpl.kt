package com.work.found.root.home.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.HomeRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.Container
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.root.home.view.HomeFragment

class HomeRouterImpl : HomeRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openHomeScreen(manager: FragmentManager) {
        addFragment(
            fragmentManager = manager,
            fragment = HomeFragment.newInstance(),
            animation = Animation.noAnimation(),
        )
    }
}