package com.work.found.core.api.state

sealed class Result<T> {

    object Loading : Result<Nothing>()

    class Success<T>(data: T) : Result<T>()

    class Error<T : Throwable>(error: T) : Result<T>()
}
