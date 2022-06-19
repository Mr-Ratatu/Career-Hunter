package com.work.found.work.articles.provider

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.base.state.ViewState

interface ArticlesViewStateInput : ViewState<ArticlesDataProviderInput> {
    fun updateArticles(articles: ArticlesItem?)
}

class ArticlesViewStateImpl : ArticlesViewStateInput {

    override val dataProvider = ArticlesDataProviderImpl()

    override fun updateArticles(articles: ArticlesItem?) {
        dataProvider.article.value = articles
    }
}