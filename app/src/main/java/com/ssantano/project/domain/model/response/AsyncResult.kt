package com.ssantano.project.domain.model.response

import com.ssantano.project.domain.model.response.error.AsyncError

sealed class AsyncResult<out T>(open val data: T?) {

  data class Success<out T>(override val data: T?) : AsyncResult<T>(data)
  data class Error<out T>(val error: AsyncError, override val data: T?) : AsyncResult<T>(data)
  data class Loading<out T>(override val data: T?) : AsyncResult<T>(data)
}

fun <T> loadingAsyncResult(data: T? = null) = AsyncResult.Loading(data)