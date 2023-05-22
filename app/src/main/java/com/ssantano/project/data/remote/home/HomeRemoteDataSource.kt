package com.ssantano.project.data.remote.home

import com.ssantano.project.data.datasource.home.HomeDataSource
import com.ssantano.project.domain.model.home.HomeBO

class HomeRemoteDataSource : HomeDataSource {

  override fun getHomeDataList(): List<HomeBO> {
    return listOf(
      HomeBO(1, "Prueba 1"),
      HomeBO(2, "Prueba 2"),
    )
  }

  override fun getHomeData(id: Long): HomeBO {
    return HomeBO(id, "Prueba $id")
  }
}