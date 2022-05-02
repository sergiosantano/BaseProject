package com.ssantano.project.domain

import kotlinx.coroutines.CoroutineDispatcher

class AppDispatchers(
  val main: CoroutineDispatcher,
  val io: CoroutineDispatcher
)