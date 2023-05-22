package com.ssantano.project.domain.model.response.error

class KoreException(val asyncError: AsyncError) : Exception() {

  override fun toString(): String {
    return asyncError.toString()
  }

}