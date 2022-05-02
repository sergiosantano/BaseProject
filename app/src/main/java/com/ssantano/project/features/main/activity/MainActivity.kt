package com.ssantano.project.features.main.activity

import android.view.View
import com.ssantano.project.common.ui.BaseActivity
import com.ssantano.project.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

  private var binding: ActivityMainBinding? = null

  override fun initBinding(): View? {
    binding = ActivityMainBinding.inflate(layoutInflater)
    return binding?.root
  }

  override fun initViewModel() {
    /* No op */
  }

  override fun initView() {
    /* No op */
  }
}