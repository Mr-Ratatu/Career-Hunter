package com.work.found.di

import com.work.found.core.di.dependencies.*
import com.work.found.work.articles.impl.di.ArticlesDependencies
import com.work.found.work.work_list.di.WorkListDependencies

interface Dependencies :
    SplashDependencies,
    RootDependencies,
    WorkListDependencies,
    WorkDerailDependencies,
    ArticlesDependencies,
    AuthDependencies,
    SearchDependencies,
    HomeDependencies