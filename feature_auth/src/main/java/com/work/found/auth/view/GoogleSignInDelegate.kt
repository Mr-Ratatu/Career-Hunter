package com.work.found.auth.view

import android.app.Activity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.work.found.auth.di.AuthComponent
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.base.utils.Constants.RC_SIGN_IN
import javax.inject.Inject

class GoogleSignInDelegate(component: AuthComponent) {

    @Inject
    lateinit var googleSignInOptions: GoogleSignInOptions

    private val signInClient: GoogleSignInClient
    private val activity = AppConfig.application.applicationContext as Activity

    init {
        component.inject(this)

        signInClient = GoogleSignIn.getClient(activity, googleSignInOptions)
    }

    fun onSignIn() {
        activity.startActivityForResult(signInClient.signInIntent, RC_SIGN_IN)
    }
}