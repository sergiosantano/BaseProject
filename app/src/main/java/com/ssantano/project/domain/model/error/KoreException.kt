package com.ssantano.project.domain.model.error

class KoreException(private val asyncError: AsyncError) : Exception() {

  override fun toString(): String {
    return asyncError.toString()
  }

}