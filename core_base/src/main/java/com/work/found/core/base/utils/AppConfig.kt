package com.work.found.core.base.utils

import android.app.Application

object AppConfig {

    val application: Application get() = fieldApplication

    private lateinit var fieldApplication: Application

    fun init(app: Application): AppConfig {
        fieldApplication = app
        return this
    }
}