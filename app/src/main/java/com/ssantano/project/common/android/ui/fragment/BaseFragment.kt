package com.ssantano.project.common.android.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ssantano.project.common.android.extensions.launchAndCollectLatest
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.navigation.NavigationCommand

abstract class BaseFragment<VB: ViewBinding> : Fragment() {

  private var _binding: VB? = null
  // This property is only valid between onCreateView and onDestroyView.
  protected val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = inflateViewBinding(inflater, container)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    initNavigation()
    initViews()
    initViewModel()
  }

  override fun onDestroy() {
    super.onDestroy()
    releaseComponents()
    _binding = null
  }

  abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

  abstract fun getViewModel(): BaseViewModel

  abstract fun initViews()

  abstract fun initViewModel()

  abstract fun releaseComponents()

  open fun getExtras(): FragmentNavigator.Extras = FragmentNavigatorExtras()

  private fun initNavigation() {
    launchAndCollectLatest(getViewModel().navEvent) { processNavigation(it) }
  }

  private fun processNavigation(command: NavigationCommand) {
    when (command) {
      is NavigationCommand.To -> findNavController().navigate(
        command.directions,
        getExtras()
      )

      is NavigationCommand.Back -> findNavController().navigateUp()
    }
  }
}