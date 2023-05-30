package com.ssantano.project.domain.model.response

sealed class Result<out E, out V> {
    data class Error<out E>(val value: E): Result<E, Nothing>()
    data class Success<out V>(val value: V): Result<Nothing, V>()
    
    inline fun and(f: (V) -> Unit): Result<E, V> = when(this) {
        is Error -> this
        is Success -> {
            f(value)
            this
        }
    }

    inline fun <V2> map(f: (V) -> V2): Result<E, V2> = when (this) {
        is Error -> this
        is Success -> Success(f(value))
    }

    inline fun <E2> mapError(f: (E) -> E2): Result<E2, V> = when (this) {
        is Error -> Error(f(value))
        is Success -> this
    }

    inline fun <A> fold(
        ifError: (E) -> A,
        ifSuccess: (V) -> A,
    ): A = when (this) {
        is Error -> ifError(value)
        is Success -> ifSuccess(value)
    }

    inline fun onError(action: (E) -> Unit): Result<E, V> =
        also { if (it is Error) action(it.value) }

    inline fun onSuccess(action: (V) -> Unit): Result<E, V> =
        also { if (it is Success) action(it.value) }
}

fun <E> E.toError() = Result.Error(this)

fun <V> V.toSuccess() = Result.Success(this)