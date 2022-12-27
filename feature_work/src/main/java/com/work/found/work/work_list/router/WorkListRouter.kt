package com.work.found.work.work_list.router

import androidx.fragment.app.FragmentManager
import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl
import com.work.found.routing.modules.ArticlesRoutingModule
import com.work.found.routing.modules.AuthRoutingModule
import com.work.found.routing.modules.SearchRoutingModule
import com.work.found.routing.modules.WorkDetailRoutingModule

class WorkListRouter : WorkListRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openWorkDetailScreen(manager: FragmentManager, id: String) {
        addFragmentToRoot(
            clazz = WorkDetailRoutingModule::class,
            fragmentManager = manager,
            bundle = WorkDetailRoutingModule.putIdArgument(id),
            needToBackStack = true,
        )
    }

    override fun openSearchScreen(manager: FragmentManager) {
        addFragmentToRoot(
            clazz = SearchRoutingModule::class,
            fragmentManager = manager,
            needToBackStack = true,
        )
    }

    override fun openAuthScreen(manager: FragmentManager) {
        addFragmentToRoot(
            clazz = AuthRoutingModule::class,
            fragmentManager = manager,
            needToBackStack = true,
        )
    }

    override fun openArticleScreen(manager: FragmentManager, id: Int) {
        addFragmentToRoot(
            clazz = ArticlesRoutingModule::class,
            fragmentManager = manager,
            bundle = ArticlesRoutingModule.putIdArgument(id),
            needToBackStack = true,
        )
    }
}