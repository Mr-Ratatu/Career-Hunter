package com.work.found.core.base.utils

sealed interface StateResult {

    object Loading: StateResult

    class Success<out T>(data: T): StateResult

    class Error(error: Throwable): StateResult
}