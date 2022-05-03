package com.ssantano.project.di.components

import android.content.Context
import com.ssantano.project.MyApplication
import com.ssantano.project.data.datasource.database.di.DatabaseModule
import com.ssantano.project.data.datasource.remote.di.DataSourcesModule
import com.ssantano.project.data.datasource.remote.di.NetworkModule
import com.ssantano.project.data.repository.di.RepositoryModule
import com.ssantano.project.domain.usecases.di.UseCaseModule
import com.ssantano.project.features.di.ViewModelModule
import com.ssantano.project.features.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    DataSourcesModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    ViewModelModule::class,
  ]
)
interface ApplicationComponent: AndroidInjector<MyApplication> {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance applicationContext: Context): ApplicationComponent
  }

}