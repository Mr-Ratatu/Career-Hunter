package com.work.found.work.work_list.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.router.Container
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.work.work_list.view.WorkListFragment

class WorkListRouter : WorkListRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openWorkListScreen(manager: FragmentManager) {
        addFragment(
            fragmentManager = manager,
            fragment = WorkListFragment.newInstance(),
            container = Container.HOME
        )
    }
}