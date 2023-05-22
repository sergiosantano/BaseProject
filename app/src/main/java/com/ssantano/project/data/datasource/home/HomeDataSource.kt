package com.ssantano.project.data.datasource.home

import com.ssantano.project.domain.model.home.HomeBO

interface HomeDataSource {
  fun getHomeDataList(): List<HomeBO>
  fun getHomeData(id: Long): HomeBO
}