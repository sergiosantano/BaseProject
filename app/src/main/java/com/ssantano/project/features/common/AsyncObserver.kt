package com.ssantano.project.features.common

import androidx.lifecycle.Observer
import com.ssantano.project.domain.model.response.AsyncResult
import com.ssantano.project.domain.model.response.error.AsyncError

open class AsyncObserver<T> : Observer<AsyncResult<T>> {

  override fun onChanged(result: AsyncResult<T>) {
    when(result) {
      is AsyncResult.Success -> onSuccess(result.data)
      is AsyncResult.Loading -> onLoading(true, result.data)
      is AsyncResult.Error -> onError(result.error, result.data)
    }
  }

  open fun onSuccess(result: T?) {
    onLoading(false, result)
  }

  open fun onError(error: AsyncError, result: T?) {
    onLoading(false, result)
  }

  open fun onLoading(loading: Boolean, result: T?) {
    //no-op
  }
}