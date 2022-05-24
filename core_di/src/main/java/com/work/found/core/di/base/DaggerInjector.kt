package com.work.found.core.di.base

object DaggerInjector {
    private lateinit var appComponent: BaseComponent

    fun getAppComponent() = appComponent

    fun initAppComponent(componentCreator: ComponentCreator) {
        if (DaggerInjector::appComponent.isInitialized) {
            return
        }

        appComponent = componentCreator.create()
    }

    inline fun <reified T> appDependencies(): T {
        val component = getAppComponent()
        if (component !is T) {
            throw IllegalAccessException("AppComponent must implementation ${T::class.java.simpleName}")
        }

        return component
    }
}