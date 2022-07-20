package com.work.found.core.api.model.work

import com.google.gson.annotations.SerializedName

data class LogoUrls(
    @SerializedName("240")
    val mediumIcon: String? = null,
    @SerializedName("90")
    val smallIcon: String? = null,
    val original: String? = null
)