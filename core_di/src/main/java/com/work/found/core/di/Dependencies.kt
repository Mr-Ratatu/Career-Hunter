package com.work.found.core.di

import com.work.found.core.di.dependencies.RootDependencies
import com.work.found.core.di.dependencies.SplashDependencies
import com.work.found.core.di.dependencies.WorkListDependencies

interface Dependencies :
    SplashDependencies,
    RootDependencies,
    WorkListDependencies