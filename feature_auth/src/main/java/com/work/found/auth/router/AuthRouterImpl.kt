package com.work.found.auth.router

import com.work.found.routing.router.FragmentRouter
import com.work.found.routing.router.FragmentRouterImpl

class AuthRouterImpl : AuthRouterInput, FragmentRouter by FragmentRouterImpl()