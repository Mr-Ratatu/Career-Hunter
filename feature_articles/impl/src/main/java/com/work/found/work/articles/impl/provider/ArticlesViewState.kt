package com.work.found.work.articles.impl.provider

import com.work.found.core.base.state.ViewState
import com.work.found.work.articles.api.model.ArticlesItem

interface ArticlesViewStateInput : ViewState<ArticlesDataProviderInput> {
    fun updateArticles(articles: ArticlesItem?)
}

class ArticlesViewStateImpl : ArticlesViewStateInput {

    override val dataProvider = ArticlesDataProviderImpl()

    override fun updateArticles(articles: ArticlesItem?) {
        dataProvider.article.value = articles
    }
}