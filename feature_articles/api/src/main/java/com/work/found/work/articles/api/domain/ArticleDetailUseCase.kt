package com.work.found.work.articles.api.domain

import com.work.found.work.articles.api.model.ArticlesItem

interface ArticleDetailUseCase {
    operator fun invoke(articleId: Int): ArticlesItem?
}