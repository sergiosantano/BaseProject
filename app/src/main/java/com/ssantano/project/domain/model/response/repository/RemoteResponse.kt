package com.ssantano.project.domain.model.response.repository

import com.ssantano.project.domain.model.response.AsyncResult
import com.ssantano.project.domain.model.response.error.AsyncError
import com.ssantano.project.domain.model.response.error.KoreException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class RemoteResponse<ResultType> {

  private var flow: Flow<AsyncResult<ResultType>>? = null

  private val response = object : RepositoryResponse<ResultType> {
    override suspend fun flow(): Flow<AsyncResult<ResultType>>  = executeFlow()
    override suspend fun value(): AsyncResult<ResultType> = executeBase {}
  }

  fun build() = response

  private fun executeFlow(): Flow<AsyncResult<ResultType>> {
    return flow ?: flow {
      executeBase { emit(it) }
    }.apply { flow = this }
  }

  private suspend fun executeBase(emit: suspend (AsyncResult<ResultType>) -> Unit): AsyncResult<ResultType> {
    emit(AsyncResult.Loading(null))
    val finalValue: AsyncResult<ResultType> = try {
      val networkResponse = requestRemoteCall()
      AsyncResult.Success(networkResponse)
    } catch (e: Exception) {
      val asyncError = (e as? KoreException)?.asyncError
        ?: AsyncError.UnknownError("An error happened", e)
      onRemoteError(asyncError)
      AsyncResult.Error(asyncError, null)
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