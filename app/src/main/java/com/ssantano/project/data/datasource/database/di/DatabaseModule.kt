package com.ssantano.project.data.datasource.database.di

import com.ssantano.project.MyApplication
import com.ssantano.project.data.datasource.database.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

  @Provides
  @Singleton
  fun provideAppDatabase(context: MyApplication): AppDataBase {
    return AppDataBase.buildDatabase(context)
  }

}