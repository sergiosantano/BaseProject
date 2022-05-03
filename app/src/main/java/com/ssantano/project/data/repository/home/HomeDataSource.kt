package com.ssantano.project.data.repository.home

import com.ssantano.project.domain.model.home.HomeBO

interface HomeDataSource {
  fun getHomeDataList(): List<HomeBO>
  fun getHomeData(id: Long): HomeBO
}