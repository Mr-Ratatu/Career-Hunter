package com.work.found.core.api.wrapers

import java.io.InputStream

interface ResourceWrapper {
    fun getInputStream(assetName: String): InputStream
}