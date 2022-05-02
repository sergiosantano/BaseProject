package com.ssantano.project.data.repository.util

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(
  val main: CoroutineDispatcher,
  val io: CoroutineDispatcher
)