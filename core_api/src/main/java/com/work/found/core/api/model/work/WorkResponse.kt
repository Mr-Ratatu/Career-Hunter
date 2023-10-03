package com.work.found.core.api.model.work

import com.google.gson.annotations.SerializedName

data class WorkResponse(
    @SerializedName("alternate_url")
    val alternativeUrl: String,

    @SerializedName("items")
    val works: List<Works>,

    @SerializedName("page")
    val currentPage: Int,

    @SerializedName("per_page")
    val perPage: Int
)