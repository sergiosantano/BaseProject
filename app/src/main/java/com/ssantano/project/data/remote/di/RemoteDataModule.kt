package com.ssantano.project.data.remote.di

import com.ssantano.project.data.remote.home.HomeRemoteDataSource
import com.ssantano.project.data.datasource.home.HomeDataSource
import org.koin.dsl.module

val remoteDataModule = module {
    // Services
    /* Write here your APIs */

    // DataSources
    single<HomeDataSource> { HomeRemoteDataSource() }
}