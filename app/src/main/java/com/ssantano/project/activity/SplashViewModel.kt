package com.ssantano.project.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val isLoadingLD = MutableStateFlow(true)

    fun isLoadingLD() = isLoadingLD.asStateFlow()

    init {
        requestInitialData()
    }

    private fun requestInitialData() {
        viewModelScope.launch(Dispatchers.IO) {
            // Add your initial operations here
            delay(2000)
            isLoadingLD.value = false
        }
    }
}