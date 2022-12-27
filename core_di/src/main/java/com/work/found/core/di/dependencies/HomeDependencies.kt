package com.work.found.core.di.dependencies

import com.work.found.core.api.interactors.NetworkConnectionInteractor

interface HomeDependencies {
    fun connectionInteractor(): NetworkConnectionInteractor
}