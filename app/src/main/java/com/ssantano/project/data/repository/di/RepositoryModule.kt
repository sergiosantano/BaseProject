package com.ssantano.project.data.repository.di

import com.ssantano.project.data.repository.home.HomeRepositoryImpl
import com.ssantano.project.domain.usecases.home.gateway.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}