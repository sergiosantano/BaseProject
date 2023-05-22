package com.ssantano.project.features.home.di

import com.ssantano.project.features.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeFeatureModule = module {
    viewModel { HomeViewModel(get()) }
}