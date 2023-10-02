package com.work.found.work.articles.impl.presenter

import com.work.found.core.base.presenter.BasePresenter
import com.work.found.core.base.state.ViewState
import com.work.found.core.di.base.DaggerInjector
import com.work.found.work.articles.api.domain.ArticleDetailUseCase
import com.work.found.work.articles.impl.di.DaggerArticlesComponent
import com.work.found.work.articles.impl.provider.ArticlesViewStateImpl
import com.work.found.work.articles.impl.provider.ArticlesViewStateInput
import com.work.found.work.articles.impl.view.ArticlesViewOutput
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticlesPresenter : BasePresenter<ArticlesViewStateInput>(), ArticlesViewOutput {

    @Inject
    lateinit var articlesUseCase: ArticleDetailUseCase

    init {
        DaggerArticlesComponent
            .builder()
            .dependencies(DaggerInjector.appDependencies())
            .build()
            .inject(this)
    }

    override fun onLoadArticles(id: Int) {
        presenterScope.launch(Dispatchers.IO) {
            val articles = articlesUseCase(articleId = id)
            withContext(Dispatchers.Main) {
                viewState.updateArticles(articles)
            }
        }
    }

    override fun provideViewState(): ViewState<*> {
        return ArticlesViewStateImpl()
    }
}