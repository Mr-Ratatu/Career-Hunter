package com.work.found.core.api.model.work

data class WorkResponse(
    val alternate_url: String,
    val arguments: Any,
    val clusters: Any,
    val found: Int,
    val items: List<WorkDto>,
    val page: Int,
    val pages: Int,
    val per_page: Int
)