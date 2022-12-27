package com.work.found.work.articles.router

import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl

class ArticlesRouterImpl : ArticlesRouterInput, FragmentRouter by FragmentRouterImpl()