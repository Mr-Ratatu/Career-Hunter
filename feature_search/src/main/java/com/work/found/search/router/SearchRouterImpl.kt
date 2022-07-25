package com.work.found.search.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.SearchRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.search.view.SearchFragment

class SearchRouterImpl : SearchRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun openSearchScreen(manager: FragmentManager) {
        addFragment(
            fragment = SearchFragment.newInstance(),
            fragmentManager = manager,
            needToBackStack = true,
            animation = Animation.defaultAnimation()
        )
    }
}