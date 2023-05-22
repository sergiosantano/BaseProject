package com.ssantano.project.common.android.ui.behaviours

import com.ssantano.project.common.android.widget.loading.LoadingView

interface LoadingBehaviour {

    fun setLoading(isLoading: Boolean) {
        getLoadingView().updateVisibility(isLoading)
    }

    fun getLoadingView(): LoadingView

}