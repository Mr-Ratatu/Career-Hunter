package com.work.found.auth.di

import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.work.found.auth.BuildConfig
import com.work.found.auth.interactor.AuthInteractorImpl
import com.work.found.auth.interactor.AuthInteractorInput
import dagger.Module
import dagger.Provides

@Module
class AuthModule {

    @Provides
    @AuthScope
    fun provideInteractor(): AuthInteractorInput {
        return AuthInteractorImpl()
    }

    @Provides
    @AuthScope
    fun provideGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(BuildConfig.WEB_CLIENT_ID)
            .requestEmail()
            .build()
    }
}