package com.work.found.auth.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.work.found.auth.R
import com.work.found.auth.presenter.AuthPresenter
import com.work.found.auth.provider.AuthDataProvider
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.popBackStack
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.Constants.RC_SIGN_IN
import com.work.found.core.base.utils.ViewInsetsController

class AuthFragment : BaseFragment<AuthViewOutput, AuthDataProvider>() {

    companion object {
        private const val NON_BREAKING_SPACE = "\u00a0"

        fun newInstance() = AuthFragment()
    }

    private lateinit var auth: FirebaseAuth

    private val authDivider = contentView<TextView>(R.id.auth_tv_divider)
    private val authToolbar = contentView<Toolbar>(R.id.articles_tb)

    override val layoutId: Int = R.layout.fragment_auth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        auth = FirebaseApp.getInstance() as FirebaseAuth
    }

    override fun initViewOutput(): AuthViewOutput {
        return AuthPresenter()
    }

    override fun initView() {
        authDivider { initDivider() }
        authToolbar {
            setNavigationOnClickListener {
                popBackStack()
            }
        }
    }

    private fun TextView.initDivider() {
        val orText = resources.getString(R.string.divider_text)
        val dividerText =
            "$NON_BREAKING_SPACE$NON_BREAKING_SPACE$orText$NON_BREAKING_SPACE$NON_BREAKING_SPACE"
        val spannable = SpannableString(dividerText)
        val color = context.getColor(com.work.found.work.core_view.R.color.white)
        spannable.setSpan(
            BackgroundColorSpan(color),
            0,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        text = spannable
    }

    override fun subscribeOnData() {
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        /*val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener(requireActivity()) { authResult ->
                startActivity(
                    Intent(
                        requireActivity(),
                        Class.forName("com.work.found.root.root_activity.view.RootActivity")
                    )
                )
            }
            .addOnFailureListener(requireActivity()) { e ->
            }*/
    }
}