package com.work.found.auth.presenter

import com.work.found.auth.provider.AuthViewState
import com.work.found.auth.provider.AuthViewStateImpl
import com.work.found.auth.view.AuthViewOutput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState

class AuthPresenter : BasePresenter<AuthViewState>(), AuthViewOutput {

    override fun provideViewState(): ViewState<*> {
        return AuthViewStateImpl()
    }
}