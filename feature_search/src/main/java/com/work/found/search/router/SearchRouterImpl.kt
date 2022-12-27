package com.work.found.search.router

import androidx.fragment.app.FragmentManager
import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl
import com.work.found.routing.modules.WorkDetailRoutingModule

class SearchRouterImpl : SearchRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openWorkDetailScreen(manager: FragmentManager, id: String) {
        addFragmentToRoot(
            clazz = WorkDetailRoutingModule::class,
            fragmentManager = manager,
            bundle = WorkDetailRoutingModule.putIdArgument(id),
            needToBackStack = true,
        )
    }
}