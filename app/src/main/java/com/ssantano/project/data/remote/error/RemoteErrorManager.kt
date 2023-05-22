package com.ssantano.project.data.remote.error

import com.squareup.moshi.JsonDataException
import com.ssantano.project.domain.model.response.error.AsyncError
import com.ssantano.project.domain.model.response.error.KoreException
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
      is UnknownHostException -> AsyncError.ConnectionError(
        throwable.message
          ?: "Error de conexion"
      )

      is JsonDataException -> AsyncError.DataParseError(throwable.message ?: "Error de parseo")
      else -> AsyncError.UnknownError(throwable.message ?: "Error desconocido", throwable)
    }
  }

  private fun processRetrofitError(httpException: HttpException): AsyncError {
    val errorCode = httpException.code()
    val url = httpException.response()?.raw()?.request?.url?.toString().orEmpty()
    return AsyncError.ServerError(errorCode, url)
  }
}