package com.work.found.work.work_list.presenter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.work.found.core.api.router.ArticlesRouterInput
import com.work.found.core.api.router.SearchRouterInput
import com.work.found.core.api.router.AuthRouterInput
import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.work_list.di.DaggerWorkListComponent
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import com.work.found.work.work_list.provider.WorkListViewStateImpl
import com.work.found.work.work_list.provider.WorkListViewStateInput
import com.work.found.work.work_list.view.WorkListViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkListPresenter : BasePresenter<WorkListViewStateInput>(), WorkListViewOutput {

    @Inject
    lateinit var interactor: WorkListInteractorInput

    @Inject
    lateinit var detailRouter: WorkDetailRouterInput

    @Inject
    lateinit var articlesRouter: ArticlesRouterInput

    @Inject
    lateinit var authRouter: AuthRouterInput

    @Inject
    lateinit var searchRouter: SearchRouterInput

    init {
        DaggerWorkListComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun <T : LifecycleOwner> onAttachView(view: T) {
        super.onAttachView(view)

        loadWorkList()
        loadArticles()
    }

    private fun loadWorkList() {
        presenterScope.launch(Dispatchers.IO) {
            val response = interactor.fetchWorkList(vacanciesName = "Android")
            viewState.updateState(response)
        }
    }

    private fun loadArticles() {
        presenterScope.launch(Dispatchers.IO) {
            viewState.updateArticles(interactor.loadArticles(AppConfig.application))
        }
    }

    override fun showDetailInfoAboutVacancy(id: String, manager: FragmentManager) {
        detailRouter.openWorkDetailScreen(id, manager)
    }

    override fun showDetailInfoAboutArticles(id: Int, manager: FragmentManager) {
        articlesRouter.showArticlesScreen(manager, id)
    }

    override fun showSearchScreen(manager: FragmentManager) {
        searchRouter.openSearchScreen(manager)
    }

    override fun showFilterScreen() {
        // TODO
    }

    override fun showAuthScreen(manager: FragmentManager) {
        authRouter.showAuthScreen(manager)
    }

    override fun onReloadData() {
        loadWorkList()
        loadArticles()
    }

    override fun provideViewState(): ViewState<*> {
        return WorkListViewStateImpl()
    }
}