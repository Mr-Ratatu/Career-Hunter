package com.work.found.work.di

import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkListScope

@WorkListScope
@Component()
interface WorkListComponent {

}