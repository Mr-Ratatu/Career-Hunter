package com.work.found.root.home.router

import androidx.fragment.app.FragmentManager
import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl
import com.work.found.routing.modules.WorkListRoutingModule

class HomeRouterImpl : HomeRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openWorkListScreen(manager: FragmentManager) {
        addFragmentToHome(
            clazz = WorkListRoutingModule::class,
            fragmentManager = manager,
        )
    }
}