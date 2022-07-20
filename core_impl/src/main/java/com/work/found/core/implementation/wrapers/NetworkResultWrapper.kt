package com.work.found.core.implementation.wrapers

import dagger.Reusable
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.UnknownHostException
import com.work.found.core.api.state.Result
import com.work.found.core.api.wrapers.ResultWrapper

@Reusable
class NetworkResultWrapper : ResultWrapper {

    override suspend fun <T> wrapWithResult(block: suspend () -> T?): Result<T> {
        return try {
            val value = block()
            if (value == null || (value is Iterable<*> && value.none())) {
                Result.NotFoundError
            } else {
                Result.Success(value)
            }
        } catch (unknownHostException: UnknownHostException) {
            Result.ConnectionError
        } catch (httpException: HttpException) {
            if (httpException.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                Result.NotFoundError
            } else {
                Result.Error(httpException)
            }
        } catch (throwable: Throwable) {
            Result.Error(throwable)
        }
    }
}
