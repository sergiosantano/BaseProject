package com.ssantano.project.common.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.ssantano.project.common.android.lifecycle.Event
import com.ssantano.project.navigation.NavigationCommand

open class BaseViewModel: ViewModel() {

    // Navigation LiveData
    private val navigationLD = MutableLiveData<Event<NavigationCommand>>()
    fun getNavigation(): LiveData<Event<NavigationCommand>> = navigationLD

    // region Navigation
    fun navigate(directions: NavDirections) {
        navigationLD.postValue(Event(NavigationCommand.To(directions)))
    }

    fun navigateBack() {
        navigationLD.postValue(Event(NavigationCommand.Back))
    }
    // endregion
}