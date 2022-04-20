package com.work.found.core.base.state

interface DataProvider

interface DataHolder<T : DataProvider> {
    val dataProvider: T
}