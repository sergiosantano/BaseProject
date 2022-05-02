package com.ssantano.project.data.datasource.remote.error

import com.google.gson.JsonParseException
import com.ssantano.project.domain.model.error.AsyncError
import com.ssantano.project.domain.model.error.KoreException
import retrofit2.HttpException
import java.net.UnknownHostException
import java.util.logging.Level
import java.util.logging.Logger

object RemoteErrorManager {

  private val log = Logger.getLogger(RemoteErrorManager::class.java.simpleName)

  inline fun <T> wrap(block: () -> T): T {
    return try {
      block()
    } catch (e: Throwable) {
      throw KoreException(processError(e))
    }
  }

  fun processError(throwable: Throwable): AsyncError {
    log.log(Level.INFO, "RemoteErrorManagement", throwable)
    return when (throwable) {
      is HttpException -> processRetrofitError(throwable)
      is UnknownHostException -> AsyncError.ConnectionError(throwable.message
        ?: "Error de conexion")
      is JsonParseException -> AsyncError.DataParseError(throwable.message ?: "Error de parseo")
      else -> AsyncError.UnknownError(throwable.message ?: "Error desconocido", throwable)
    }
  }

  private fun processRetrofitError(httpException: HttpException): AsyncError {
    val errorCode = httpException.code()
    val url = httpException.response()?.raw()?.request?.url?.toString().orEmpty()
    return AsyncError.ServerError(errorCode, url)
  }
}