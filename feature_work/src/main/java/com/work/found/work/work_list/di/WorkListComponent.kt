package com.work.found.work.work_list.di

import com.work.found.core.api.interactors.NetworkConnectionInteractor
import com.work.found.core.api.network_service.WorksNetworkDataSource
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.domain.ArticlesListUseCase
import com.work.found.work.work_list.WorkListViewModel
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

    val connectionInteractor: NetworkConnectionInteractor
    val useCase: WorkListUseCase
    val articlesListUseCase: ArticlesListUseCase
}

interface WorkListDependencies {
    fun workService(): WorkServiceInput
    fun articlesService(): ArticlesService
    fun connectionInteractor(): NetworkConnectionInteractor
    fun networkDataSource(): WorksNetworkDataSource
    fun articlesListUseCase(): ArticlesListUseCase
}

fun WorkListComponent.constructWorkListViewModel() = WorkListViewModel(
    articlesListUseCase = articlesListUseCase,
    connectionInteractor = connectionInteractor,
    workListUseCase = useCase
)