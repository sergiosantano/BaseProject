package com.ssantano.project.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.AsyncResult
import com.ssantano.project.domain.model.response.loadingAsyncResult
import com.ssantano.project.domain.usecases.home.GetHomeDataListUC
import com.ssantano.project.navigation.NavigationCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(
  private val getHomeDataListUC: GetHomeDataListUC
) : BaseViewModel() {

  private val mainDataLiveData = MutableLiveData<AsyncResult<List<HomeBO>>>()

  fun mainDataLD() = mainDataLiveData as LiveData<AsyncResult<List<HomeBO>>>


  fun requestData() {
    viewModelScope.launch(Dispatchers.IO) {
      mainDataLiveData.postValue(loadingAsyncResult())
      val result = getHomeDataListUC()
      delay(10000)
      mainDataLiveData.postValue(result)
    }
  }

  fun navigateToSecondFragment() {
    viewModelScope.launch { navigate(NavigationCommand.To(HomeFragmentDirections.toSecondFragment())) }
  }

}