package com.work.found.work.articles.router

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.ArticlesRouterInput
import com.work.found.core.base.router.Animation
import com.work.found.core.base.router.FragmentRouter
import com.work.found.core.base.router.FragmentRouterImpl
import com.work.found.work.articles.view.ArticlesFragment
import javax.inject.Inject

class ArticlesRouterImpl @Inject constructor() :
    ArticlesRouterInput,
    FragmentRouter by FragmentRouterImpl() {

    override fun showArticlesScreen(manager: FragmentManager, argumentId: Int) {
        addFragment(
            fragment = ArticlesFragment.newInstance(argumentId),
            fragmentManager = manager,
            animation = Animation.scaleFadeAnimation(),
            needToBackStack = true
        )
    }
}