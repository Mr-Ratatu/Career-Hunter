package com.work.found.di

import com.work.found.auth.di.AuthDependencies
import com.work.found.root.home.di.HomeDependencies
import com.work.found.root.root_activity.di.RootDependencies
import com.work.found.search.di.SearchDependencies
import com.work.found.splash.di.SplashDependencies
import com.work.found.work.articles.impl.di.ArticlesDependencies
import com.work.found.work.detail.di.WorkDetailDependencies
import com.work.found.work.work_list.di.WorkListDependencies

interface Dependencies :
    SplashDependencies,
    RootDependencies,
    WorkListDependencies,
    WorkDetailDependencies,
    ArticlesDependencies,
    AuthDependencies,
    SearchDependencies,
    HomeDependencies