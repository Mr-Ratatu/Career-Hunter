package com.work.found.work.work_list.presenter

import androidx.fragment.app.FragmentManager
import com.work.found.core.api.router.WorkDetailRouterInput
import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.base.utils.States
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

    init {
        DaggerWorkListComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)

        presenterScope.launch(Dispatchers.IO) {
            val response = interactor.fetchWorkList(vacanciesName = "Android")

            withContext(Dispatchers.Main) {
                viewState.updateState(States.LOADING)
                response
                    .onSuccess { work ->
                        viewState.updateWorkList(work)
                        viewState.updateState(States.SUCCESS)
                    }
                    .onFailure { error ->
                        viewState.updateState(States.ERROR)
                    }
            }
        }

        loadArticles()
    }

    private fun loadArticles() {
        presenterScope.launch(Dispatchers.IO) {
            val articles = interactor.loadArticles(AppConfig.application)
            withContext(Dispatchers.Main) {
                viewState.updateArticles(articles)
            }
        }
    }

    override fun showDetailInfoAboutVacancy(id: String, manager: FragmentManager) {
        detailRouter.openWorkDetailScreen(id, manager)
    }

    override fun showDetailInfoAboutArticles(id: Int) {
        // TODO
    }

    override fun showSearchScreen() {
        // TODO
    }

    override fun showFilterScreen() {
        // TODO
    }

    override fun provideViewState(): ViewState<*> {
        return WorkListViewStateImpl()
    }
}