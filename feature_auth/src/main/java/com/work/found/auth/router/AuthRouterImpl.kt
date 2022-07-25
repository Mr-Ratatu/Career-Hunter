package com.work.found.auth.router

import androidx.fragment.app.FragmentManager
import com.work.found.auth.view.AuthFragment
import com.work.found.core.api.router.AuthRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl

class AuthRouterImpl : AuthRouterInput, FragmentRouter by FragmentRouterImpl() {

    override fun showAuthScreen(manager: FragmentManager) {
        addFragment(
            fragment = AuthFragment.newInstance(),
            fragmentManager = manager,
            needToBackStack = true,
            animation = Animation.defaultAnimation()
        )
    }
}