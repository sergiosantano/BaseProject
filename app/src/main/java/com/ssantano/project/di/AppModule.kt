package com.ssantano.project.di

import android.content.Context
import com.ssantano.project.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton
  fun provideApplication(app: MyApplication): MyApplication {
    return app
  }

  @Provides
  @Singleton
  fun provideContext(app: MyApplication): Context {
    return app
  }

}