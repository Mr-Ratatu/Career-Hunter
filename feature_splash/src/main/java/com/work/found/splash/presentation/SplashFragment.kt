package com.work.found.splash.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.work.found.core.api.router.WorkListRouterInput
import com.work.found.core.base.extensions.createDependency
import com.work.found.splash.R
import com.work.found.splash.di.SplashComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var router: WorkListRouterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(3000)
            router.openWorkListScreen(parentFragmentManager)
        }
    }

    private fun initDagger() {
        SplashComponent
            .create(createDependency())
            .inject(this)
    }

}