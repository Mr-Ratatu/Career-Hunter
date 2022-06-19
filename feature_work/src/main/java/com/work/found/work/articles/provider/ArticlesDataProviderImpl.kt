package com.work.found.work.articles.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.base.state.DataProvider

interface ArticlesDataProviderInput : DataProvider {
    val article: LiveData<ArticlesItem?>
}

class ArticlesDataProviderImpl : ArticlesDataProviderInput {
    override val article = MutableLiveData<ArticlesItem?>()
}