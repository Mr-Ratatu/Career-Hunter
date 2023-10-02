package com.work.found.work.articles.impl.provider

import com.work.found.core.base.state.DataProvider
import com.work.found.work.articles.api.model.ArticlesItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

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