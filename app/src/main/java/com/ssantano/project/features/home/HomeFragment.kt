package com.ssantano.project.features.home

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ssantano.project.R
import com.ssantano.project.domain.model.home.HomeBO
import com.ssantano.project.features.base.BaseFragment
import com.ssantano.project.features.di.viewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : BaseFragment() {

  // region Views
  private var testLabel: TextView? = null
  // endregion

  // region Observers
  private val mainDataObserver = Observer<List<HomeBO>> { data ->
    val text = StringBuilder().apply {
      data.forEach { appendLine("${it.id} - ${it.text}") }
    }.toString()
    testLabel?.text = text
  }
  // endregion

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel: HomeViewModel by viewModel { viewModelFactory }

  override fun getLayoutResId(): Int = R.layout.fragment__home

  override fun initDagger() {
    AndroidSupportInjection.inject(this)
  }

  override fun bindViews(view: View) {
    testLabel = view.findViewById(R.id.fragment_home__label__test)
  }

  override fun initViews() {
    // No-op
  }

  override fun initViewModel() {
    viewModel.mainDataLD().observe(viewLifecycleOwner, mainDataObserver)

    viewModel.requestData()
  }

}