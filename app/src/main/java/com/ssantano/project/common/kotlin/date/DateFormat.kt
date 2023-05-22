package com.ssantano.project.common.kotlin.date

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

sealed class DateFormat(private val format: String) {

  fun parse(text: String): Date? {
    val pattern = SimpleDateFormat(format, Locale.getDefault())
    return try {
      pattern.parse(text)
    } catch (exception: Exception) {
      null
    }
  }

  object MonthDayYearWithSlashHourMinutesWithColon : DateFormat("MM/dd/yyyy HH:mm")
}
