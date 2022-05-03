package com.ssantano.project.data.repository.home

import com.ssantano.project.data.datasource.remote.home.HomeRemoteDataSource
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository

class HomeRepositoryImpl(private val remoteDataSource: HomeRemoteDataSource): HomeRepository {

  override fun getHomeDataList(): List<HomeBO> {
    return remoteDataSource.getHomeDataList()
  }

  override fun getHomeData(id: Long): HomeBO {
    return remoteDataSource.getHomeData(id)
  }
}