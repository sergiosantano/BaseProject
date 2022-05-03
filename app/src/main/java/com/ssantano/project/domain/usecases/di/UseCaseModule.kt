package com.ssantano.project.domain.usecases.di

import com.ssantano.project.domain.usecases.home.GetHomeDataListUC
import com.ssantano.project.domain.usecases.home.GetHomeDataListUCImpl
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

  @Provides
  fun provideGetHomeDataListUC(repository: HomeRepository) =
    GetHomeDataListUCImpl(repository) as GetHomeDataListUC

}