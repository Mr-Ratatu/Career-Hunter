package com.work.found.work.articles.provider

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.base.state.DataProvider
import kotlinx.coroutines.flow.*

interface ArticlesDataProviderInput : DataProvider {
    val article: Flow<ArticlesItem?>
    val title: Flow<String>
    val description: Flow<String>
    val poster: Flow<String>
}

class ArticlesDataProviderImpl : ArticlesDataProviderInput {

    override val article = MutableStateFlow<ArticlesItem?>(null)

    override val title = article.map { it?.title }.filterNotNull()

    override val description = article.map { it?.description }.filterNotNull()

    override val poster = article.map { it?.poster }.filterNotNull()
}