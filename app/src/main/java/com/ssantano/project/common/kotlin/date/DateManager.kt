package com.ssantano.project.common.kotlin.date

import java.util.*

interface DateManager {

  fun getDateFromDateAndTimeStrings(date: String?, time: String?, dateFormats: DateFormat): Date?

}

class DateManagerImpl : DateManager {

  override fun getDateFromDateAndTimeStrings(
    date: String?,
    time: String?,
    dateFormats: DateFormat
  ): Date? {
    val fullDate = "${date.orEmpty()} ${time.orEmpty()}"
    return dateFormats.parse(fullDate)
  }

}