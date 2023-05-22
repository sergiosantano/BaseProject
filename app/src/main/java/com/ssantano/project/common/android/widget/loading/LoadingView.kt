package com.ssantano.project.common.android.widget.loading

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.ssantano.project.R
import com.ssantano.project.databinding.WidgetLoadingViewBinding

class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding =
        WidgetLoadingViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        this.isVisible = false
        binding.widgetLoadingContainerRoot.setBackgroundColor(ContextCompat.getColor(context, R.color.bg__loading))
    }

    fun updateVisibility(isLoading: Boolean) {
        this.isVisible = isLoading
    }
}