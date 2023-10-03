package com.work.found.work.detail.di

import com.work.found.core.api.services.WorkServiceInput
import com.work.found.work.detail.WorkDetailViewModel
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class WorkDetailScope

@WorkDetailScope
@Component(
    modules = [WorkDetailModule::class],
    dependencies = [WorkDetailDependencies::class],
)
interface WorkDetailComponent {

    @Component.Builder
    interface Build {

        fun dependencies(dependencies: WorkDetailDependencies): Build

        fun build(): WorkDetailComponent
    }

    fun inject(target: WorkDetailViewModel)

    val workDetailInteractor: WorkDetailInteractorInput
}

interface WorkDetailDependencies {

    fun workService(): WorkServiceInput
}

fun WorkDetailComponent.constructWorkDetailViewModel(
    workId: String
) = WorkDetailViewModel(
    workId = workId,
    interactor = workDetailInteractor,
)