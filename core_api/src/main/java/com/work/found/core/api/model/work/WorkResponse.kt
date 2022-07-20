package com.work.found.core.api.model.work

data class WorkResponse(
    val alternate_url: String,
    val found: Int,
    val items: List<WorkDto>,
    val page: Int,
    val pages: Int,
    val per_page: Int
)