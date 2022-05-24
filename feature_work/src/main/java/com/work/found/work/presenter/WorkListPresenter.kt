package com.work.found.work.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.di.DaggerWorkListComponent
import com.work.found.work.interactor.WorkListInteractorInput
import com.work.found.work.provider.WorkListViewStateImpl
import com.work.found.work.provider.WorkListViewStateInput
import com.work.found.work.view.WorkListViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WorkListPresenter : BasePresenter<WorkListViewStateInput>(), WorkListViewOutput {

    @Inject
    lateinit var interactor: WorkListInteractorInput

    init {
        DaggerWorkListComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)

        presenterScope.launch(Dispatchers.IO) {
            interactor.fetchWorkList(vacanciesName = "Android") { response ->
                viewState.updateLoading(true)
                response
                    .onSuccess { work ->
                        viewState.updateWorkList(work)
                        viewState.updateLoading(false)
                    }
                    .onFailure { error ->
                        viewState.updateError(error)
                        viewState.updateLoading(false)
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

    override fun showDetailInfoAboutVacancy(id: String) {
        // TODO
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