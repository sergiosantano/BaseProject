package com.ssantano.project.domain.model.response.error

sealed class AsyncError(val debugMessage: String) {
  class ConnectionError(debugMessage: String) : AsyncError(debugMessage)
  class DataParseError(debugMessage: String) : AsyncError(debugMessage)
  class ServerError(val code: Int, debugMessage: String) : AsyncError(debugMessage)
  class UnknownError(debugMessage: String, val errorThrown: Throwable) : AsyncError(debugMessage)
  open class CustomError(debugMessage: String) : AsyncError(debugMessage)
}
