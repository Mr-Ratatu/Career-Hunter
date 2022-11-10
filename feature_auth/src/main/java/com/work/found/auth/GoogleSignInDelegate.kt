package com.work.found.auth

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class GoogleSignInDelegate(
    private val context: Context,
    private val signInOptions: GoogleSignInOptions,
) {

    private val auth by lazy { FirebaseAuth.getInstance() }
    private val googleSignInClient = GoogleSignIn.getClient(context, signInOptions)

    fun getSignInIntent() = googleSignInClient.signInIntent
}