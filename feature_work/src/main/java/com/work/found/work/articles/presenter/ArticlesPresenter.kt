package com.work.found.work.articles.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.base.utils.AppConfig
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.articles.di.DaggerArticlesComponent
import com.work.found.work.articles.interactor.ArticlesInteractorInput
import com.work.found.work.articles.provider.ArticlesViewStateImpl
import com.work.found.work.articles.provider.ArticlesViewStateInput
import com.work.found.work.articles.view.ArticlesViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesPresenter : BasePresenter<ArticlesViewStateInput>(), ArticlesViewOutput {

    @Inject
    lateinit var interactor: ArticlesInteractorInput

    init {
        DaggerArticlesComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun onLoadArticles(id: Int) {
        presenterScope.launch(Dispatchers.IO) {
            val articles = interactor.loadArticles(AppConfig.application, id)
            withContext(Dispatchers.Main) {
                viewState.updateArticles(articles)
            }
        }
    }

    override fun provideViewState(): ViewState<*> {
        return ArticlesViewStateImpl()
    }
}