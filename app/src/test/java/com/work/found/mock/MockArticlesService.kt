package com.work.found.mock

import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.api.services.ArticlesServiceInput

internal class MockArticlesService : ArticlesServiceInput {

    override fun loadArticles(articlesAssetName: String): List<ArticlesItem> {
        return articlesList
    }

    companion object {
        val articlesList = listOf(
            ArticlesItem(
                id = 0,
                icon = "ic_icon",
                description = "",
                title = "",
                poster = ""
            ),
            ArticlesItem(
                id = 1,
                icon = "ic_icon",
                description = "",
                title = "",
                poster = ""
            ),
            ArticlesItem(
                id = 2,
                icon = "ic_icon",
                description = "",
                title = "",
                poster = ""
            ),
        )
    }
}