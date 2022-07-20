package com.work.found

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.mock.MockArticlesService
import com.work.found.mock.MockWorkService
import com.work.found.work.work_list.interactor.WorkListInteractorImpl
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.net.UnknownHostException

internal class WorkListInteractorTest {

    private val unknownHostException = UnknownHostException()
    private val inputValue = "Android"

    private lateinit var interactor: WorkListInteractorInput
    private val articlesService: ArticlesServiceInput = MockArticlesService()
    private var service: WorkServiceInput = MockWorkService(unknownHostException = unknownHostException)

    @Test
    fun `should return success work list result`() = runBlockingTest {
        // GIVEN
        service = MockWorkService(returnSuccess = true, unknownHostException = unknownHostException)
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Success(MockWorkService.workResponse)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return error work list result`() = runBlockingTest {
        // GIVEN
        service = MockWorkService(returnError = true, unknownHostException = unknownHostException)
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Error(unknownHostException)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return loading work list result`() = runBlockingTest {
        // GIVEN
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Loading

        // THEN
        assertEquals(expected, actual)
    }

    /*@Test
    fun `should return articles result`() = runBlockingTest {
        // GIVEN
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.loadArticles(context)
        val expected = emptyList<ArticlesItem>()

        // THEN
        assertFalse(expected == actual)
    }*/
}