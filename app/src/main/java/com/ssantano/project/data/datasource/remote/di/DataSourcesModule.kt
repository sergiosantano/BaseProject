package com.ssantano.project.data.datasource.remote.di

import com.ssantano.project.data.datasource.remote.home.HomeRemoteDataSource
import com.ssantano.project.data.repository.home.HomeDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class DataSourcesModule {

  @Provides
  @Named("homeRemoteDataSource")
  fun provideHomeRemoteDataSource(): HomeDataSource = HomeRemoteDataSource()

}