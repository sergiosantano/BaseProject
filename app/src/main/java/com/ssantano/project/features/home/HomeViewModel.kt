package com.ssantano.project.features.home

import androidx.lifecycle.viewModelScope
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.common.android.ui.viewmodel.EventEmitter
import com.ssantano.project.common.android.ui.viewmodel.EventEmitterImpl
import com.ssantano.project.common.android.ui.viewmodel.StateHolder
import com.ssantano.project.common.android.ui.viewmodel.StateHolderImpl
import com.ssantano.project.common.android.ui.viewmodel.UiState
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.Result
import com.ssantano.project.domain.usecases.home.GetHomeDataListFlowUC
import com.ssantano.project.navigation.NavigationCommand
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class HomeUiState(
  override val isLoading: Boolean = false,
  val data: List<HomeBO> = emptyList()
) : UiState()

sealed interface HomeUiEvent {
  class ShowError(val message: String) : HomeUiEvent
  object LaunchSampleDialog : HomeUiEvent
}

class HomeViewModel(
  private val getHomeDataListFlowUC: GetHomeDataListFlowUC
) : BaseViewModel(),
  StateHolder<HomeUiState> by StateHolderImpl(HomeUiState()),
  EventEmitter<HomeUiEvent> by EventEmitterImpl() {

  fun requestDataStateFlow() {
    viewModelScope.launch {
      setState { it.copy(isLoading = true) }
      delay(5000)

      getHomeDataListFlowUC().collect { result ->
        when (result) {
          is Result.Error -> throwError(result.value.debugMessage)
          is Result.Success -> setState { it.copy(isLoading = false, data = result.value) }
        }
      }
    }
  }

  fun showSampleDialog() {
    viewModelScope.launch { sendEvent(HomeUiEvent.LaunchSampleDialog) }
  }

  fun navigateToSecondFragment() {
    viewModelScope.launch { navigate(NavigationCommand.To(HomeFragmentDirections.toSecondFragment())) }
  }

  private suspend fun throwError(message: String) {
    sendEvent(HomeUiEvent.ShowError(message))
    setState { it.copy(isLoading = false) }
  }
}