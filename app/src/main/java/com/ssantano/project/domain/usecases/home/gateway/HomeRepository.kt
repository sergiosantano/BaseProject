package com.ssantano.project.domain.usecases.home.gateway

import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.repository.RepositoryResponse

interface HomeRepository {
  fun getHomeDataList(): RepositoryResponse<List<HomeBO>>
  fun getHomeData(id: Long): RepositoryResponse<HomeBO>
}