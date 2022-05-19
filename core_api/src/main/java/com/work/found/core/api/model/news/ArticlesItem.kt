package com.work.found.core.api.model.news

import androidx.annotation.DrawableRes

data class ArticlesItem(
    val id: Int,
    @DrawableRes val icon: Int,
    val title: String,
)