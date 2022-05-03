package com.ssantano.project.domain.usecases.home

import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository

interface GetHomeDataListUC {
  suspend operator fun invoke(): List<HomeBO>
}

class GetHomeDataListUCImpl(private val homeRepository: HomeRepository): GetHomeDataListUC {
  override suspend fun invoke(): List<HomeBO> {
    return homeRepository.getHomeDataList()
  }
}