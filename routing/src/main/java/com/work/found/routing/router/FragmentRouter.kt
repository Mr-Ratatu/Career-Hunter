package com.work.found.routing.router

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.work.found.routing.R
import com.work.found.routing.base.Animation
import com.work.found.routing.base.AppModules
import com.work.found.routing.base.RoutingModule
import com.work.found.routing.base.setCustomAnimations
import kotlin.reflect.KClass

interface FragmentRouter {

    fun <T : RoutingModule> addFragmentToHome(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle? = null,
        needToBackStack: Boolean = false,
        animation: Animation = Animation.defaultAnimation(),
        needHideLastScreen: Boolean = false,
        isReplace: Boolean = false,
    )

    fun <T : RoutingModule> addFragmentToRoot(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle? = null,
        needToBackStack: Boolean = false,
        animation: Animation = Animation.defaultAnimation(),
        needHideLastScreen: Boolean = false,
        isReplace: Boolean = false,
    )
}

open class FragmentRouterImpl : FragmentRouter {

    override fun <T : RoutingModule> addFragmentToHome(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle?,
        needToBackStack: Boolean,
        animation: Animation,
        needHideLastScreen: Boolean,
        isReplace: Boolean,
    ) = addFragment(
        fragment = AppModules.moduleInstance(clazz, bundle),
        fragmentManager = fragmentManager,
        needToBackStack = needToBackStack,
        animation = animation,
        containerId = R.id.home_container_fl,
        needHideLastScreen = needHideLastScreen,
        isReplace = isReplace,
    )

    override fun <T : RoutingModule> addFragmentToRoot(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle?,
        needToBackStack: Boolean,
        animation: Animation,
        needHideLastScreen: Boolean,
        isReplace: Boolean,
    ) = addFragment(
        fragment = AppModules.moduleInstance(clazz, bundle),
        fragmentManager = fragmentManager,
        needToBackStack = needToBackStack,
        animation = animation,
        containerId = R.id.main_container_fl,
        needHideLastScreen = needHideLastScreen,
        isReplace = isReplace,
    )

    private fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean,
        animation: Animation,
        containerId: Int,
        needHideLastScreen: Boolean,
        isReplace: Boolean,
    ) {
        fragmentManager.commit {
            setCustomAnimations(animation)
            setReorderingAllowed(true)

            if (needHideLastScreen) {
                fragmentManager.fragments.lastOrNull { !it.isHidden }?.let(::hide)
            }

            when (isReplace) {
                true -> replace(containerId, fragment)
                false -> add(containerId, fragment)
            }

            if (needToBackStack) {
                addToBackStack(fragment::class.toString())
            }
        }
    }
}
