package com.ssantano.project.di

import com.ssantano.project.common.kotlin.date.DateManager
import com.ssantano.project.common.kotlin.date.DateManagerImpl
import org.koin.dsl.module

val appModule = module {
    single<DateManager> { DateManagerImpl() }
}
