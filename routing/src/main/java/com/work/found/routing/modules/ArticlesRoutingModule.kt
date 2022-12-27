package com.work.found.routing.modules

import android.os.Bundle
import com.work.found.routing.base.RoutingModule

interface ArticlesRoutingModule : RoutingModule {
    companion object {
        const val ARTICLE_ID_KEY = "detail_id"
        fun putIdArgument(id: Int) = Bundle().apply {
            putInt(ARTICLE_ID_KEY, id)
        }
    }
}