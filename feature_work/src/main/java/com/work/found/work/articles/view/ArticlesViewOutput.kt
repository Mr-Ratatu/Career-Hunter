package com.work.found.work.articles.view

import com.work.found.core.base.presentation.ViewOutput

interface ArticlesViewOutput : ViewOutput {
    fun onLoadArticles(id: Int)
}