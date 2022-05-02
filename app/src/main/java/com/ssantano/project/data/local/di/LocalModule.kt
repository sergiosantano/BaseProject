package com.ssantano.project.data.local.di

import com.ssantano.project.data.local.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {

  // Database
  single { AppDataBase.buildDatabase(androidApplication()) }

  // DAO

  // DataSources

}