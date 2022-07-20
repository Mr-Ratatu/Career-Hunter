package com.work.found.core.api.wrapers

import com.work.found.core.api.state.Result

interface ResultWrapper {

    suspend fun <T> wrapWithResult(block: suspend () -> T?): Result<T>
}
