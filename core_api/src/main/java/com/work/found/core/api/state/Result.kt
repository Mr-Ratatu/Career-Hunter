package com.work.found.core.api.state

sealed class Result<out T> {

    data class Success<out T>(val value: T) : Result<T>()

    object Error : Result<Nothing>()

    object ConnectionError : Result<Nothing>()

    object NotFoundError : Result<Nothing>()

    object Loading : Result<Nothing>()
}