package com.ssantano.project.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.ssantano.project.common.android.extensions.launchAndCollect
import com.ssantano.project.common.android.extensions.launchAndCollectLatest
import com.ssantano.project.common.android.recycler.adapter.ItemsAdapter
import com.ssantano.project.common.android.ui.behaviours.LoadingBehaviour
import com.ssantano.project.common.android.ui.dialog.bottom.DefaultBottomDialog
import com.ssantano.project.common.android.ui.fragment.BaseFragment
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.common.android.widget.loading.LoadingView
import com.ssantano.project.databinding.FragmentHomeBinding
import com.ssantano.project.features.home.adapter.HomeViewHolderProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(), LoadingBehaviour {

  private val viewModel: HomeViewModel by viewModel()

  private val adapter: ItemsAdapter<String> by lazy {
    ItemsAdapter(HomeViewHolderProvider())
  }

  override fun inflateViewBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ): FragmentHomeBinding {
    return FragmentHomeBinding.inflate(inflater, container, false)
  }

  override fun getViewModel(): BaseViewModel {
    return viewModel
  }

  override fun initViews() {
    binding.homeListTest.adapter = adapter

    binding.homeButtonDialogSample.setOnClickListener {
      viewModel.showSampleDialog()
    }

    binding.homeButtonNavSample.setOnClickListener { viewModel.navigateToSecondFragment() }
  }

  override fun initViewModel() {
    launchAndCollect(viewModel.uiState) { updateUi(it) }
    launchAndCollectLatest(viewModel.uiEvent) { onUiEventReceived(it) }

    viewModel.requestDataStateFlow()
  }

  override fun releaseComponents() {
    binding.homeListTest.adapter = null
  }

  override fun getLoadingView(): LoadingView {
    return binding.homeViewLoading
  }

  private fun updateUi(uiState: HomeUiState) {
    val data = uiState.data.map { "${it.id} - ${it.text}" }
    adapter.submitList(data)
  }

  private fun onUiEventReceived(event: HomeUiEvent) {
    when (event) {
      HomeUiEvent.HideLoading -> setLoading(false)
      is HomeUiEvent.ShowError -> Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
      HomeUiEvent.ShowLoading -> setLoading(true)
      HomeUiEvent.LaunchSampleDialog -> {
        val dialog = DefaultBottomDialog.newInstance("Ejemplo de descripcion", "CANCELAR")
        dialog.show(childFragmentManager, "DialogTag")
      }
    }
  }
}