package com.work.found.work.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.work.view.WorkListFragment
import javax.inject.Inject

class WorkListRouterImpl @Inject constructor() : WorkListRouterInput,
    FragmentRouter by FragmentRouterImpl() {

    override fun openWorkListScreen(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction().apply {
            addFragment(
                fragment = WorkListFragment.newInstance(),
                fragmentManager = fragmentManager
            )
        }
    }
}