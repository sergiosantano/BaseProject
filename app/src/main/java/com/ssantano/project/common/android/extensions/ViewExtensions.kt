package com.ssantano.project.common.android.extensions

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

//region All Views
/** Visibility */
fun View.hide() {
  this.visibility = View.GONE
}

fun View.hideIf(condition: () -> Boolean) {
  if (condition()) hide()
}

fun View.show() {
  this.visibility = View.VISIBLE
}

fun View.showIf(condition: () -> Boolean) {
  if (condition()) show()
}

/** Modify margins */
fun View.margins(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
  layoutParams<ViewGroup.MarginLayoutParams> {
    left?.run { leftMargin = dpToPx(this) }
    top?.run { topMargin = dpToPx(this) }
    right?.run { rightMargin = dpToPx(this) }
    bottom?.run { bottomMargin = dpToPx(this) }
  }
}

inline fun <reified T : ViewGroup.MarginLayoutParams> View.layoutParams(block: T.() -> Unit) {
  if (layoutParams is T) block(layoutParams as T)
}

/** Modify paddings */
fun View.updatePadding(
  paddingStart: Int = getPaddingStart(),
  paddingTop: Int = getPaddingTop(),
  paddingEnd: Int = getPaddingEnd(),
  paddingBottom: Int = getPaddingBottom()
) {
  setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom)
}

//endregion

//region TextInput

val EditText.value
  get() = text.toString()

//endregion

// region ViewHolder

fun ViewGroup.inflater() = LayoutInflater.from(this.context)

// endregion

//region Screen
/** Keyboard */
fun View.showKeyboard() {
  val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  this.requestFocus()
  imm.showSoftInput(this, 0)
}

fun View.hideKeyboard(): Boolean {
  try {
    val inputMethodManager =
      context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
  } catch (ignored: RuntimeException) {
  }
  return false
}
//endregion

//region Utils
/** DP to PX Conversions */
fun View.dpToPx(dp: Int): Int = context.dpToPx(dp)
fun Context.dpToPx(dp: Int): Int =
  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics)
    .toInt()
//endregion