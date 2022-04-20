package com.work.found.work.interactor

interface WorkListInteractorInput {

    suspend fun fetchWorkList(callback: (Unit) -> Unit)
}