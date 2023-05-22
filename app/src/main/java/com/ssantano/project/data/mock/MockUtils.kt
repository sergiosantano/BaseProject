package com.ssantano.project.data.mock

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.IOException

fun getJsonStringFromAssets(context: Context, fileName: String): String? {
  return try {
    context.assets.open(fileName).bufferedReader().use { it.readText() }
  } catch (ioException: IOException) {
    ioException.printStackTrace()
    null
  }
}

inline fun <reified Item> convertJsonToObject(value: String): Item? {
  return try {
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Item::class.java)
    adapter.fromJson(value)

  } catch (exception: Exception) {
    null
  }
}