package com.work.found.di.modules

import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [
        NetworkModule::class,
        ServiceModule::class,
        RouterModule::class
    ]
)
interface AppModule