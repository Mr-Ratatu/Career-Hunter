package com.work.found.work.work_list.di

import com.work.found.core.base.delegates.NetworkConnectionManager
import com.work.found.core.di.dependencies.WorkListDependencies
import com.work.found.work.work_list.WorkListViewModel
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import com.work.found.work.work_list.view.WorkListFragment
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkListScope

@WorkListScope
@Component(
    modules = [WorkListModule::class],
    dependencies = [WorkListDependencies::class]
)
interface WorkListComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun coroutineScope(scope: CoroutineScope): Builder

        fun dependencies(dependencies: WorkListDependencies): Builder

        fun build(): WorkListComponent
    }

    fun inject(target: WorkListFragment)

    val interactor: WorkListInteractorInput
    val connectionManager: NetworkConnectionManager
}

fun WorkListComponent.constructWorkListViewModel() = WorkListViewModel(
    interactor = interactor,
    connectionManager = connectionManager
)