package com.ssantano.project.di.components

import com.ssantano.project.data.datasource.database.di.DatabaseModule
import com.ssantano.project.data.datasource.remote.di.NetworkModule
import com.ssantano.project.data.repository.di.RepositoryModule
import com.ssantano.project.di.AppModule
import com.ssantano.project.domain.usecases.di.UseCaseModule
import dagger.Component

@Component(
  modules = [
    AppModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
    UseCaseModule::class
  ]
)
interface ApplicationComponent: FragmentComponent, WidgetComponent {
}