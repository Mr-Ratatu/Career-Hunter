package com.work.found.auth.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.work.found.auth.BuildConfig
import com.work.found.auth.R
import com.work.found.auth.databinding.FragmentAuthBinding
import com.work.found.auth.di.DaggerAuthComponent
import com.work.found.core.base.extensions.popBackStack
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.core.di.base.DaggerInjector

class AuthFragment : Fragment() {

    private val component by lazy {
        DaggerAuthComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
    }

    private lateinit var binding: FragmentAuthBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInsetListener(binding.root)
        initView()
        subscribeOnData()

        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(BuildConfig.WEB_CLIENT_ID).requestEmail().build()

        auth = FirebaseAuth.getInstance()
        googleSignInClient = GoogleSignIn.getClient(requireContext(), signInOptions)
    }

    private fun initView() {
        binding.authTvDivider.initDivider()
        binding.authToolbar.setNavigationOnClickListener { popBackStack() }
        binding.authGoogleBtn.setOnClickListener {
            activityResult.launch(googleSignInClient.signInIntent)
        }
        binding.authEmailBtn.setOnClickListener {
            logout()
        }
    }

    private fun subscribeOnData() {
    }

    private fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RESULT_CODE) {
            val signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data)

            if (signInAccountTask.isSuccessful) {
                val account: GoogleSignInAccount =
                    signInAccountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            }
        }
    }

    private val activityResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == 0) {
            val signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(result.data)

            if (signInAccountTask.isSuccessful) {
                val account: GoogleSignInAccount =
                    signInAccountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        auth.currentUser?.displayName,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(requireContext(), "Fail", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun logout() {
        googleSignInClient.signOut().addOnCompleteListener { result ->
            if (result.isSuccessful) {
                auth.signOut()

                Toast.makeText(requireContext(), "Logout", Toast.LENGTH_SHORT).show()
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

    companion object {
        private const val NON_BREAKING_SPACE = "\u00a0"
        private const val RESULT_CODE = 200

        fun newInstance() = AuthFragment()
    }
}