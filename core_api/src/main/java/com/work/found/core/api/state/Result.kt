package com.work.found.core.api.state

sealed class Result<out T> {

    data class Success<out T>(val value: T) : Result<T>()

    data class Error(val error: Throwable? = null) : Result<Nothing>()

    object ConnectionError : Result<Nothing>()

    object NotFoundError : Result<Nothing>()

    object Loading : Result<Nothing>()
}