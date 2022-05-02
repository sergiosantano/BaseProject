package com.ssantano.project

import android.app.Application
import com.ssantano.project.data.datasource.local.di.localModule
import com.ssantano.project.data.datasource.remote.di.remoteModule
import com.ssantano.project.data.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    initDependencyInjection()
  }

  private fun initDependencyInjection() {
    startKoin {
      androidLogger()
      androidContext(this@MyApplication)
      androidFileProperties()
      modules(
        listOf(
          remoteModule,
          localModule,
          repositoryModule,
        )
      )
    }
  }

}