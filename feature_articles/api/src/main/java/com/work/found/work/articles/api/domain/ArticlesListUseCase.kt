package com.work.found.work.articles.api.domain

import com.work.found.work.articles.api.model.ArticlesItem

interface ArticlesListUseCase {
    operator fun invoke(): List<ArticlesItem>
}