package com.ssantano.project.domain.usecases.home.gateway

import com.ssantano.project.domain.model.home.HomeBO

interface HomeRepository {
  fun getHomeDataList(): List<HomeBO>
  fun getHomeData(id: Long): HomeBO
}