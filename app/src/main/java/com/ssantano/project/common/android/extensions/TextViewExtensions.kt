package com.ssantano.project.common.android.extensions

import android.widget.TextView
import androidx.core.view.isVisible

fun TextView.setTextOrHide(text: String?) {
    this.text = text
    this.isVisible = text != null
}