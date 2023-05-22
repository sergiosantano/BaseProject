package com.ssantano.project.activity

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ssantano.project.R

class NavHostActivity : AppCompatActivity() {

  private val splashViewModel: SplashViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setUpSplashScreen()
    setContentView(R.layout.activity_main)
  }

  /**
   * Override this method in order to close the keyboard whenever an EditText looses focus
   */
  override fun dispatchTouchEvent(event: MotionEvent): Boolean {
    if (event.action == MotionEvent.ACTION_DOWN) {
      val v: View? = currentFocus
      if (v is EditText) {
        val outRect = Rect()
        v.getGlobalVisibleRect(outRect)
        if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
          v.clearFocus()
          val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
          imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
        }
      }
    }
    return super.dispatchTouchEvent(event)
  }

  private fun setUpSplashScreen() {
    installSplashScreen().apply {
      setKeepOnScreenCondition {
        return@setKeepOnScreenCondition splashViewModel.isLoadingLD().value
      }
    }
  }
}