package com.work.found.routing.modules

import android.os.Bundle
import com.work.found.routing.base.RoutingModule

interface WorkDetailRoutingModule : RoutingModule {
    companion object {
        const val DETAIL_ID_KEY = "detail_id"
        fun putIdArgument(id: String) = Bundle().apply {
            putString(DETAIL_ID_KEY, id)
        }
    }
}