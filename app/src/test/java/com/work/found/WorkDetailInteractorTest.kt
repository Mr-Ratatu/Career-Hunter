package com.work.found

import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.mock.MockWorkService
import com.work.found.work.detail.interactor.WorkDetailInteractorImpl
import com.work.found.work.detail.interactor.WorkDetailInteractorInput
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import java.net.UnknownHostException

internal class WorkDetailInteractorTest {

    private val unknownHostException = UnknownHostException()
    private val inputValue = "67495966"

    private lateinit var service: WorkServiceInput

    private lateinit var interactor: WorkDetailInteractorInput

    @Test
    fun `should return success detail result`() = runBlockingTest {
        // GIVEN
        service = MockWorkService(returnSuccess = true, unknownHostException = unknownHostException)
        interactor = WorkDetailInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkDetail(id = inputValue)
        val expected = Result.Success(ExpensesFactory.workDetailResponse)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return error detail result`() = runTest {
        // GIVEN
        service = MockWorkService(returnError = true, unknownHostException = unknownHostException)
        interactor = WorkDetailInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkDetail(id = inputValue)
        val expected = Result.Error(unknownHostException)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return loading detail result`() = runTest {
        // GIVEN
        service = MockWorkService(unknownHostException = unknownHostException)
        interactor = WorkDetailInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkDetail(id = inputValue)
        val expected = Result.Loading

        // THEN
        assertEquals(expected, actual)
    }
}