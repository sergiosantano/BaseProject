package com.ssantano.project.domain.model.response.repository

import com.ssantano.project.domain.model.response.Result
import com.ssantano.project.domain.model.response.error.AsyncError
import com.ssantano.project.domain.model.response.error.KoreException
import com.ssantano.project.domain.model.response.toError
import com.ssantano.project.domain.model.response.toSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class RemoteResponse<ResultType> {

  private var flow: Flow<Result<AsyncError, ResultType>>? = null

  private val response = object : RepositoryResponse<ResultType> {
    override suspend fun flow(): Flow<Result<AsyncError, ResultType>> = executeFlow()
    override suspend fun value(): Result<AsyncError, ResultType> = executeBase { }
  }

  fun build() = response

  private fun executeFlow(): Flow<Result<AsyncError, ResultType>> {
    return flow ?: flow {
      executeBase { emit(it) }
    }.apply { flow = this }
  }

  private suspend fun executeBase(emit: suspend (Result<AsyncError, ResultType>) -> Unit): Result<AsyncError, ResultType> {
    val finalValue: Result<AsyncError, ResultType> = try {
      val networkResponse = requestRemoteCall()
      networkResponse.toSuccess()
    } catch (e: Exception) {
      val asyncError = (e as? KoreException)?.asyncError
        ?: AsyncError.UnknownError("An error happened", e)
      onRemoteError(asyncError)
      asyncError.toError()
    }
    emit(finalValue)
    return finalValue
  }

  /**
   * Method to do some logic in case of remote request fails
   */
  open suspend fun onRemoteError(asyncError: AsyncError) {
    /* no-op */
  }

  protected abstract suspend fun requestRemoteCall(): ResultType
}