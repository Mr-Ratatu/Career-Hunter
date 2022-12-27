package com.work.found.root.home.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.work.found.core.base.R
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.root.home.presenter.HomePresenter
import com.work.found.root.home.providers.HomeDataProvider

class HomeFragment : BaseFragment<HomeViewOutput, HomeDataProvider>() {

    private val navigationView = contentView<BottomNavigationView>(R.id.home_navigation_bv)
    private val connectionState = contentView<View>(R.id.home_connection_state)

    override val layoutId: Int = R.layout.home_container

    override fun initViewOutput(): HomeViewOutput {
        return HomePresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDefaultScreen()
    }

    override fun initView() {
        navigationView {
            setOnItemSelectedListener { menuId ->
                when (menuId.itemId) {
                    R.id.navigation_work -> viewOutput.onNavigationToWorkList(parentFragmentManager)
                    R.id.navigation_favorite -> Unit
                    R.id.navigation_profile -> Unit
                }
                true
            }
        }
    }

    private fun setDefaultScreen() {
        viewOutput.onNavigationToWorkList(parentFragmentManager)
    }

    override fun subscribeOnData() {
        dataProvider.isNetworkConnected.launchWhenStartedWithScope { isConnected ->
            connectionState {
                isVisible = !isConnected
            }
        }
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindPadding(rootView, forBottom = true, forTop = true)
    }
}