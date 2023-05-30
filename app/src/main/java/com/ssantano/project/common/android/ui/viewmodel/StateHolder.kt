package com.ssantano.project.common.android.ui.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface StateHolder<S> {

    val uiState: StateFlow<S>

    fun setState(update: (old: S) -> S)
}

class StateHolderImpl<S>(initialState: S) : StateHolder<S> {

    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<S> = _uiState.asStateFlow()

    override fun setState(update: (old: S) -> S) = _uiState.update(update)
}
