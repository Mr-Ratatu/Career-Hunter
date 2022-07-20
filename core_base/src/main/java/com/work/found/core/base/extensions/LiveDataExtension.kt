package com.work.found.core.base.extensions

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations

fun <T> LiveData<T>.distinctUntilChanged(compare: T?.(T?) -> Boolean = { this == it }): LiveData<T> =
    MediatorLiveData<T>().also { mediator ->
        mediator.addSource(this) { newValue ->
            if (!newValue.compare(value)) {
                mediator.postValue(newValue)
            }
        }
    }

inline fun <T> LiveData<T>.filter(crossinline filter: (T?) -> Boolean): LiveData<T> {
    return MediatorLiveData<T>().apply {
        addSource(this@filter) {
            if (filter(it)) {
                this.value = it
            }
        }
    }
}

inline fun <X, Y> LiveData<X>.map(crossinline mapFunc: (X) -> Y) = Transformations.map(this) {
    mapFunc(it)
}

fun <T> MutableLiveData<T>.safetyValue(value: T) {
    when {
        Looper.myLooper() == Looper.getMainLooper() -> setValue(value)
        else -> postValue(value)
    }
}