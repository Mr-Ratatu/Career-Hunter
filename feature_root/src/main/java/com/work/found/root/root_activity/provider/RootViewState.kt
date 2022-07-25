package com.work.found.root.root_activity.provider

import com.work.found.core.base.state.ViewState

interface RootViewState : ViewState<RootDataProvider>

class RootViewStateImpl : RootViewState {

    override val dataProvider = RootDataProviderImpl()
}

