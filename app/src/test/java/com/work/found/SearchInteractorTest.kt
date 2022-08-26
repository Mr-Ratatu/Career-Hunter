package com.work.found

import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.mock.MockWorkService
import com.work.found.search.interactor.SearchInteractorImpl
import com.work.found.search.interactor.SearchInteractorInput
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.net.UnknownHostException

internal class SearchInteractorTest {

    private val unknownHostException = UnknownHostException()
    private val inputValue = ""

    private lateinit var service: WorkServiceInput

    private lateinit var interactor: SearchInteractorInput

    @Test
    fun `should return success search result`() = runTest {
        // GIVEN
        service = MockWorkService(returnSuccess = true, unknownHostException = unknownHostException)
        interactor = SearchInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkList(inputValue)
        val expected = Result.Success(ExpensesFactory.workResponse)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return error search result`() = runTest {
        // GIVEN
        service = MockWorkService(returnError = true, unknownHostException = unknownHostException)
        interactor = SearchInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkList(inputValue)
        val expected = Result.Error(unknownHostException)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return loading search result`() = runTest {
        // GIVEN
        service = MockWorkService(unknownHostException = unknownHostException)
        interactor = SearchInteractorImpl(service)

        // WHEN
        val actual = interactor.fetchWorkList(inputValue)
        val expected = Result.Loading

        // THEN
        assertEquals(expected, actual)
    }
}