package com.ssantano.project.common.android.ui.viewmodel

import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), NavigationEventEmitter by NavigationEventEmitterImpl()