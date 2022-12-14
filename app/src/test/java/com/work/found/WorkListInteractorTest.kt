package com.work.found

import com.work.found.core.api.services.ArticlesServiceInput
import com.work.found.core.api.services.WorkServiceInput
import com.work.found.core.api.state.Result
import com.work.found.mock.MockArticlesService
import com.work.found.mock.MockWorkService
import com.work.found.work.work_list.interactor.WorkListInteractorImpl
import com.work.found.work.work_list.interactor.WorkListInteractorInput
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import java.net.HttpURLConnection
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

internal class WorkListInteractorTest {

    private val inputValue = "Android"

    private lateinit var interactor: WorkListInteractorInput
    private lateinit var articlesService: ArticlesServiceInput
    private lateinit var service: WorkServiceInput

    @Before
    fun setup() {
        articlesService = MockArticlesService()
        service = MockWorkService()
    }

    @Test
    fun `should return success work list result`() = runTest {
        // GIVEN
        service = MockWorkService(returnSuccess = true)
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Success(ExpensesFactory.workResponse)

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return error work list result`() = runTest {
        // GIVEN
        service = MockWorkService(returnError = true)
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Error

        // THEN
        assertEquals(expected, actual)
    }

    @Test
    fun `should return loading work list result`() = runTest {
        // GIVEN
        interactor = WorkListInteractorImpl(service, articlesService)

        // WHEN
        val actual = interactor.fetchWorkList(vacanciesName = inputValue)
        val expected = Result.Loading

        // THEN
        assertEquals(expected, actual)
    }

   /* @Test
    fun `check web response result`() {
        // GIVEN
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(getBody())
            .setBodyDelay(0, TimeUnit.MILLISECONDS)
        mockWebServer.enqueue(response)
        mockWebServer.start()

        // WHEN
        val actualData = "Android разработчик"

        // THEN
        assertTrue()
    }

    private fun getBody(): String {
        return "{\n" +
                "      \"id\": \"67487031\",\n" +
                "      \"premium\": false,\n" +
                "      \"name\": \"Android разработчик\",\n" +
                "      \"department\": null,\n" +
                "      \"has_test\": false,\n" +
                "      \"response_letter_required\": false,\n" +
                "      \"area\": {\n" +
                "        \"id\": \"41\",\n" +
                "        \"name\": \"Калининград\",\n" +
                "        \"url\": \"https://api.hh.ru/areas/41\"\n" +
                "      },\n" +
                "      \"salary\": {\n" +
                "        \"from\": 50000,\n" +
                "        \"to\": 100000,\n" +
                "        \"currency\": \"RUR\",\n" +
                "        \"gross\": false\n" +
                "      },\n" +
                "      \"type\": {\n" +
                "        \"id\": \"open\",\n" +
                "        \"name\": \"Открытая\"\n" +
                "      },\n" +
                "      \"address\": null,\n" +
                "      \"response_url\": null,\n" +
                "      \"sort_point_distance\": null,\n" +
                "      \"published_at\": \"2022-07-23T09:52:13+0300\",\n" +
                "      \"created_at\": \"2022-07-23T09:52:13+0300\",\n" +
                "      \"archived\": false,\n" +
                "      \"apply_alternate_url\": \"https://hh.ru/applicant/vacancy_response?vacancyId=67487031\",\n" +
                "      \"insider_interview\": null,\n" +
                "      \"url\": \"https://api.hh.ru/vacancies/67487031?host=hh.ru\",\n" +
                "      \"adv_response_url\": \"https://api.hh.ru/vacancies/67487031/adv_response?host=hh.ru\",\n" +
                "      \"alternate_url\": \"https://hh.ru/vacancy/67487031\",\n" +
                "      \"relations\": [],\n" +
                "      \"employer\": {\n" +
                "        \"id\": \"3333270\",\n" +
                "        \"name\": \"Вуду Рокс\",\n" +
                "        \"url\": \"https://api.hh.ru/employers/3333270\",\n" +
                "        \"alternate_url\": \"https://hh.ru/employer/3333270\",\n" +
                "        \"logo_urls\": {\n" +
                "          \"original\": \"https://hhcdn.ru/employer-logo-original/517454.jpg\",\n" +
                "          \"240\": \"https://hhcdn.ru/employer-logo/2511294.jpeg\",\n" +
                "          \"90\": \"https://hhcdn.ru/employer-logo/2511293.jpeg\"\n" +
                "        },\n" +
                "        \"vacancies_url\": \"https://api.hh.ru/vacancies?employer_id=3333270\",\n" +
                "        \"trusted\": true\n" +
                "      },\n" +
                "      \"snippet\": {\n" +
                "        \"requirement\": \"Опыт разработки мобильных приложений под <highlighttext>Android</highlighttext> (обязателен). Знание Kotlin или Java на уровне Junior / Middle. Знание основ ООП и базовых...\",\n" +
                "        \"responsibility\": \"Cоздание пользовательского интерфейса в приложении на основе дизайна в Sketch, Figma, Zeplin или аналогичных. Разработка внутренней структуры приложения для хранения...\"\n" +
                "      },\n" +
                "      \"contacts\": null,\n" +
                "      \"schedule\": {\n" +
                "        \"id\": \"remote\",\n" +
                "        \"name\": \"Удаленная работа\"\n" +
                "      },\n" +
                "      \"working_days\": [],\n" +
                "      \"working_time_intervals\": [],\n" +
                "      \"working_time_modes\": [],\n" +
                "      \"accept_temporary\": true\n" +
                "    },"
    }*/

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