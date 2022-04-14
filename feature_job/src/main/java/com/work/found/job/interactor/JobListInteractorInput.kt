package com.work.found.job.interactor

interface JobListInteractorInput {

    fun fetchDefaultJobList(callback: () -> Unit)
}