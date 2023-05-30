package com.ssantano.project.common.android.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.launchAndCollect(
    flow: Flow<T>,
    from: Lifecycle.State = Lifecycle.State.STARTED,
    onEach: suspend (T) -> Unit,
) {
    flow.flowWithLifecycle(lifecycle, from)
        .onEach(onEach)
        .launchIn(lifecycleScope)
}

fun <T> LifecycleOwner.launchAndCollectLatest(
    flow: Flow<T>,
    from: Lifecycle.State = Lifecycle.State.STARTED,
    onEach: suspend (T) -> Unit,
) {
    lifecycleScope.launch {
        flow.flowWithLifecycle(lifecycle, from)
            .collectLatest(onEach)
    }
}