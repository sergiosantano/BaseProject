package com.ssantano.project.data.datasource.database.di

import android.app.Application
import com.ssantano.project.data.datasource.database.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

  @Provides
  @Singleton
  fun provideAppDatabase(context: Application): AppDataBase {
    return AppDataBase.buildDatabase(context)
  }

}