package com.ssantano.project.data.local.common

data class CacheableObject<T>(
  val data: T,
  val cachedTimestamp: Long,
  val expirationTimeMillis: Long
) {

  fun isValidData() = System.currentTimeMillis() - cachedTimestamp < expirationTimeMillis

}