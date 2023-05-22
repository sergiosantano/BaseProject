package com.ssantano.project.common.android.animation

import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation


fun inFromRight(duration: Long, dimensionType: Int): Animation {
  val inFromRight: Animation = TranslateAnimation(
    dimensionType, +1.0f, dimensionType,
    0.0f, dimensionType, 0.0f, dimensionType, 0.0f
  )
  inFromRight.duration = duration
  inFromRight.interpolator = DecelerateInterpolator()
  return inFromRight
}

fun outToRight(duration: Long): Animation {
  val outToRight: Animation = TranslateAnimation(
    Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
    +1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f
  )
  outToRight.duration = duration
  outToRight.interpolator = AccelerateInterpolator()
  return outToRight
}