package com.ssantano.project.data.local.di

import com.ssantano.project.data.local.database.AppDataBase
import org.koin.dsl.module

val localDataModule = module {
    // App DataBase
    single { AppDataBase.buildDatabase(get()) }

    // DataSources
    /* Write here your Local DataSources */

}