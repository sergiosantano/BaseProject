package com.ssantano.project.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ssantano.project.common.android.ui.fragment.BaseFragment
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondViewModel: BaseViewModel()

class SecondFragment: BaseFragment<FragmentSecondBinding>() {

    private val viewModel: SecondViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(inflater, container, false)
    }

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun initViews() {
    }

    override fun initViewModel() {
    }

    override fun releaseComponents() {
    }
}