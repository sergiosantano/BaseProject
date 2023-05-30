package com.ssantano.project.domain.usecases.di

import com.ssantano.project.domain.usecases.home.GetHomeDataListFlowUC
import com.ssantano.project.domain.usecases.home.GetHomeDataListFlowUCImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetHomeDataListFlowUC> { GetHomeDataListFlowUCImpl(get()) }
}