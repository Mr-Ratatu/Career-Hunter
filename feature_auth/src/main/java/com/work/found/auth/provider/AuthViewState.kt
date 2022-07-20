package com.work.found.auth.provider

import com.work.found.core.base.state.ViewState

interface AuthViewState : ViewState<AuthDataProvider> {

}

class AuthViewStateImpl : AuthViewState {

    override val dataProvider = AuthDataProviderImpl()
}