package com.ssantano.project.data.repository.di

import com.ssantano.project.data.repository.util.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {

    // Dispatchers
    single { getAppDispatchers() }

    // Repositories
}

private fun getAppDispatchers(): AppDispatchers {
    return AppDispatchers(Dispatchers.Main, Dispatchers.IO)
}