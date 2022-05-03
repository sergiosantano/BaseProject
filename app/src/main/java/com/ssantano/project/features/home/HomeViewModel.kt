package com.ssantano.project.features.home

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.usecases.home.GetHomeDataListUC
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeViewModel(
  private val getHomeDataListUC: GetHomeDataListUC
) : ViewModel() {

  private val mainDataLiveData = MutableLiveData<List<HomeBO>>()

  fun mainDataLD() = mainDataLiveData as LiveData<List<HomeBO>>


  fun requestData() {
    viewModelScope.launch(IO) {
      val result = getHomeDataListUC()
      Handler().postDelayed({
        mainDataLiveData.postValue(result)
      }, 2000)
    }
  }

}