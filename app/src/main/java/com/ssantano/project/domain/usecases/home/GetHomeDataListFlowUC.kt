package com.ssantano.project.domain.usecases.home

import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.Result
import com.ssantano.project.domain.model.response.error.AsyncError
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository
import kotlinx.coroutines.flow.Flow

interface GetHomeDataListFlowUC {
  suspend operator fun invoke(): Flow<Result<AsyncError, List<HomeBO>>>
}

class GetHomeDataListFlowUCImpl(private val homeRepository: HomeRepository): GetHomeDataListFlowUC {
  override suspend fun invoke(): Flow<Result<AsyncError, List<HomeBO>>> {
    return homeRepository.getHomeDataList().flow()
  }
}