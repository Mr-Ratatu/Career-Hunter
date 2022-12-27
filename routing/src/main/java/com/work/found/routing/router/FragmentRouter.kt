package com.work.found.routing.router

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
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
    )

    fun <T : RoutingModule> addFragmentToRoot(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle? = null,
        needToBackStack: Boolean = false,
        animation: Animation = Animation.defaultAnimation(),
    )
}

open class FragmentRouterImpl : FragmentRouter {

    override fun <T : RoutingModule> addFragmentToHome(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle?,
        needToBackStack: Boolean,
        animation: Animation
    ) = addFragment(
        AppModules.moduleInstance(clazz, bundle),
        fragmentManager,
        needToBackStack,
        animation,
        R.id.home_container_fl
    )

    override fun <T : RoutingModule> addFragmentToRoot(
        clazz: KClass<T>,
        fragmentManager: FragmentManager,
        bundle: Bundle?,
        needToBackStack: Boolean,
        animation: Animation
    ) = addFragment(
        AppModules.moduleInstance(clazz, bundle),
        fragmentManager,
        needToBackStack,
        animation,
        R.id.main_container_fl
    )

    private fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean,
        animation: Animation,
        containerId: Int,
    ) {
        fragmentManager.beginTransaction().apply {
            setCustomAnimations(animation)
            setReorderingAllowed(true)
            replace(containerId, fragment)

            if (needToBackStack) {
                addToBackStack(fragment::class.toString())
            }
        }.commit()
    }
}
