package com.work.found.core.di.dependencies

import com.work.found.core.api.services.ArticlesServiceInput

interface ArticlesDependencies {

    fun articlesService(): ArticlesServiceInput
}