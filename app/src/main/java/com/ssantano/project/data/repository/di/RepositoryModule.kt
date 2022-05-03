package com.ssantano.project.data.repository.di

import com.ssantano.project.data.datasource.remote.home.HomeRemoteDataSource
import com.ssantano.project.data.repository.home.HomeRepositoryImpl
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

  @Provides
  fun provideHomeRepository(
    @Named("homeRemoteDataSource") remoteDataSource: HomeRemoteDataSource
  ): HomeRepository = HomeRepositoryImpl(remoteDataSource)

}