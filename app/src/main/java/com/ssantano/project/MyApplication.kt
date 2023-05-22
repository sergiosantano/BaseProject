package com.ssantano.project

import android.app.Application
import com.ssantano.project.data.local.di.localDataModule
import com.ssantano.project.data.remote.di.networkModule
import com.ssantano.project.data.remote.di.remoteDataModule
import com.ssantano.project.data.repository.di.repositoryModule
import com.ssantano.project.di.appModule
import com.ssantano.project.domain.usecases.di.useCaseModule
import com.ssantano.project.features.home.di.homeFeatureModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidLogger()
      androidContext(this@MyApplication)
      modules(
        getAppCommonModules() + getFeatureModules()
      )
    }
  }

  private fun getAppCommonModules() = listOf(
    appModule,
    localDataModule,
    networkModule,
    remoteDataModule,
    repositoryModule,
    useCaseModule,
  )

  private fun getFeatureModules() = listOf(
    homeFeatureModule
  )

}