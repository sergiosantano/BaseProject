package com.ssantano.project.common.android.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context.getColorCmpt(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)

inline val Context.inflater: LayoutInflater
  get() = LayoutInflater.from(this)

fun Context.inflateLayout(
  @LayoutRes layoutId: Int,
  parent: ViewGroup? = null,
  attachToRoot: Boolean = false
): View =
  inflater.inflate(layoutId, parent, attachToRoot)

fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
  this?.let { Toast.makeText(it, text, duration).show() }

fun Context?.toast(@StringRes textId: Int, duration: Int = Toast.LENGTH_LONG) =
  this?.let { Toast.makeText(it, textId, duration).show() }