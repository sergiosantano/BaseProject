package com.ssantano.project.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ssantano.project.common.android.recycler.adapter.ItemsAdapter
import com.ssantano.project.common.android.ui.behaviours.LoadingBehaviour
import com.ssantano.project.common.android.ui.dialog.bottom.DefaultBottomDialog
import com.ssantano.project.databinding.FragmentHomeBinding
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.domain.model.response.error.AsyncError
import com.ssantano.project.common.android.ui.fragment.BaseFragment
import com.ssantano.project.common.android.ui.viewmodel.BaseViewModel
import com.ssantano.project.common.android.widget.loading.LoadingView
import com.ssantano.project.features.common.AsyncObserver
import com.ssantano.project.features.home.adapter.HomeViewHolderProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(), LoadingBehaviour {

  // region Observers
  private val mainDataObserver = object : AsyncObserver<List<HomeBO>>() {
    override fun onLoading(loading: Boolean, result: List<HomeBO>?) {
      setLoading(loading)
    }

    override fun onSuccess(result: List<HomeBO>?) {
      super.onSuccess(result)
      val data = result.orEmpty().map { "${it.id} - ${it.text}" }
      adapter.submitList(data)
    }

    override fun onError(error: AsyncError, result: List<HomeBO>?) {
      super.onError(error, result)
      // Do your error logic
    }
  }
  // endregion

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
      val dialog = DefaultBottomDialog.newInstance("Ejemplo de descripcion", "CANCELAR")
      dialog.show(childFragmentManager, "DialogTag")
    }

    binding.homeButtonNavSample.setOnClickListener { viewModel.navigateToSecondFragment() }
  }

  override fun initViewModel() {
    viewModel.mainDataLD().observe(viewLifecycleOwner, mainDataObserver)

    viewModel.requestData()
  }

  override fun releaseComponents() {
    // No-op
  }

  override fun getLoadingView(): LoadingView {
    return binding.homeViewLoading
  }
}