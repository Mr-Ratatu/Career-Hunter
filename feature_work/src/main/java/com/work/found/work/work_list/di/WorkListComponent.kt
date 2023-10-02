package com.work.found.work.work_list.di

import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.di.dependencies.WorkListDependencies
import com.work.found.work.work_list.WorkListViewModel
import com.work.found.work.work_list.domain.WorkListInteractorInput
import com.work.found.work.work_list.domain.WorkListUseCase
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
    val connectionInteractor: NetworkConnectionInteractor
    val useCase: WorkListUseCase
}

fun WorkListComponent.constructWorkListViewModel() = WorkListViewModel(
    interactor = interactor,
    connectionInteractor = connectionInteractor,
    useCase = useCase
)