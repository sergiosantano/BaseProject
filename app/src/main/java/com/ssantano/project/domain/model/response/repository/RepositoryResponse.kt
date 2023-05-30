package com.ssantano.project.domain.model.response.repository

import com.ssantano.project.domain.model.response.Result
import com.ssantano.project.domain.model.response.error.AsyncError
import kotlinx.coroutines.flow.Flow

interface RepositoryResponse<ResultType> {
  suspend fun flow(): Flow<Result<AsyncError, ResultType>>
  suspend fun value(): Result<AsyncError, ResultType>
}