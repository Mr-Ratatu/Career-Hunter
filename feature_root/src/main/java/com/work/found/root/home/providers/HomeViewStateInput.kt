package com.work.found.root.home.providers

import com.work.found.core.base.state.ViewState

interface HomeViewStateInput : ViewState<HomeDataProvider>

class HomeViewStateImpl : HomeViewStateInput {
    override val dataProvider = HomeDataProviderImpl()
}