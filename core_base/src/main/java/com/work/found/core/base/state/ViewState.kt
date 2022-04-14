package com.work.found.core.base.state

interface ViewStateInput

interface ViewState<T : DataProvider> : ViewStateInput, DataHolder<T>