package com.ssantano.project.common.kotlin.extensions

import java.util.*

private const val PHONE_REGEXP = "^1([34578])\\d{9}\$"
private const val EMAIL_REGEXP = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)\$"
private const val NUM_REGEXP = "^[0-9]+$"

fun String.isPhone(): Boolean = matches(PHONE_REGEXP.toRegex())

fun String.isEmail(): Boolean = matches(EMAIL_REGEXP.toRegex())

fun String.isNumeric(): Boolean = matches(NUM_REGEXP.toRegex())

fun String.equalsIgnoreCase(other: String) = this.lowercase(Locale.getDefault())
  .contentEquals(
    other.lowercase(Locale.getDefault())
  )
