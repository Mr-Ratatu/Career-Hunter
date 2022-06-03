package com.work.found.core.api.model.work

import com.google.gson.annotations.SerializedName

data class LogoUrls(
    @SerializedName("240")
    val mediumIcon: String,
    @SerializedName("90")
    val smallIcon: String,
    val original: String
)