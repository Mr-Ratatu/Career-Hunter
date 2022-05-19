package com.work.found.splash.provider

import com.work.found.core.base.state.ViewState

interface SplashViewState: ViewState<SplashDataProvider>

class SplashViewStateImpl : SplashViewState {

    override val dataProvider = SplashDataProviderImpl()
}