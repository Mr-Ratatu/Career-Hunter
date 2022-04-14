package com.work.found.di

import dagger.Component

@Component
interface ApplicationComponent {

    companion object {
        fun create(): ApplicationComponent {
            return DaggerApplicationComponent
                .builder()
                .build()
        }
    }
}