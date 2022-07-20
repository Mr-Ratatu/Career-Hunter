package com.work.found.di.modules

import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        ServiceModule::class,
        RouterModule::class,
        UtilsModule::class
    ]
)
interface AppModule