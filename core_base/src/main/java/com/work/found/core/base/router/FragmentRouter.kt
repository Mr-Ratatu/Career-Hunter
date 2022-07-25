package com.work.found.core.base.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.work.found.core.base.R

enum class Container {
    MAIN, HOME
}

interface FragmentRouter {

    fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean = false,
        animation: Animation = Animation.noAnimation(),
        container: Container = Container.MAIN
    )
}

open class FragmentRouterImpl : FragmentRouter {

    companion object {
        private val MAIN_CONTAINER = R.id.main_container_fl
        private val HOME_CONTAINER = R.id.home_container_fl
    }

    override fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean,
        animation: Animation,
        container: Container
    ) {
        fragmentManager.beginTransaction().apply {
            val fragmentContainer = when (container) {
                Container.MAIN -> MAIN_CONTAINER
                Container.HOME -> HOME_CONTAINER
            }
            setCustomAnimations(animation)
            setReorderingAllowed(true)
            replace(fragmentContainer, fragment)

            if (needToBackStack) {
                addToBackStack(fragment::class.toString())
            }
        }.commit()
    }

}