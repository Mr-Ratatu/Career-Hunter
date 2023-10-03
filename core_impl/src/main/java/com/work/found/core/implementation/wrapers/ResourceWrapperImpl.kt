package com.work.found.core.implementation.wrapers

import android.content.Context
import com.work.found.core.api.wrapers.ResourceWrapper
import java.io.InputStream

class ResourceWrapperImpl(private val context: Context): ResourceWrapper {
    override fun getInputStream(assetName: String): InputStream {
        return context.assets.open(assetName)
    }
}