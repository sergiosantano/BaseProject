package com.ssantano.project.domain.model.response.repository

import com.ssantano.project.domain.model.response.AsyncResult
import kotlinx.coroutines.flow.Flow

interface RepositoryResponse<ResultType> {
  suspend fun flow(): Flow<AsyncResult<ResultType>>
  suspend fun value(): AsyncResult<ResultType>
}