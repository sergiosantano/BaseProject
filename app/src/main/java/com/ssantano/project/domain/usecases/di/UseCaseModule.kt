package com.ssantano.project.domain.usecases.di

import com.ssantano.project.domain.usecases.home.GetHomeDataListUC
import com.ssantano.project.domain.usecases.home.GetHomeDataListUCImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHomeDataListUC> { GetHomeDataListUCImpl(get()) }
}