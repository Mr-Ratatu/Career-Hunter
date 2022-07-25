package com.work.found.work.detail.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.Container
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.work.detail.view.WorkDetailFragment

class WorkDetailRouterImpl : WorkDetailRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openWorkDetailScreen(id: String, manager: FragmentManager) {
        addFragment(
            fragment = WorkDetailFragment.newInstance(id),
            fragmentManager = manager,
            animation = Animation.scaleFadeAnimation(),
            needToBackStack = true,
            container = Container.HOME
        )
    }
}