package com.ssantano.project.features.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ssantano.project.MyApplication
import com.ssantano.project.di.components.ApplicationComponent

abstract class BaseFragment : Fragment() {

  override fun onAttach(context: Context) {
    super.onAttach(context)
    (requireContext() as? MyApplication)?.appComponent?.let { initDagger(it) }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = layoutInflater.inflate(getLayoutResId(), container, false)
    bindViews(view)
    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    initViews()
  }

  @LayoutRes
  abstract fun getLayoutResId(): Int

  abstract fun initDagger(appComponent: ApplicationComponent)

  abstract fun bindViews(view: View)

  abstract fun initViews()
}