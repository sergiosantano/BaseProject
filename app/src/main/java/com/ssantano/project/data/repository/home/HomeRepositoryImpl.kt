package com.ssantano.project.data.repository.home

import com.ssantano.project.data.datasource.home.HomeDataSource
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.repository.RemoteResponse
import com.ssantano.project.domain.model.response.repository.RepositoryResponse
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository

class HomeRepositoryImpl(private val remoteDataSource: HomeDataSource): HomeRepository {

  override fun getHomeDataList(): RepositoryResponse<List<HomeBO>> {
    return object : RemoteResponse<List<HomeBO>>() {
      override suspend fun requestRemoteCall(): List<HomeBO> {
        return remoteDataSource.getHomeDataList()
      }
    }.build()
  }

  override fun getHomeData(id: Long): RepositoryResponse<HomeBO> {
    return object : RemoteResponse<HomeBO>() {
      override suspend fun requestRemoteCall(): HomeBO {
        return remoteDataSource.getHomeData(id)
      }
    }.build()
  }
}