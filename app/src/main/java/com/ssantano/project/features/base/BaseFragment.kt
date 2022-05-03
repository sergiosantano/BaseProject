package com.ssantano.project.features.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

  override fun onAttach(context: Context) {
    super.onAttach(context)
    initDagger()
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
    initViewModel()
  }

  @LayoutRes
  abstract fun getLayoutResId(): Int

  abstract fun initDagger()

  abstract fun bindViews(view: View)

  abstract fun initViews()

  abstract fun initViewModel()
}