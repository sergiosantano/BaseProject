package com.ssantano.project.common.android.ui.viewmodel

import com.ssantano.project.navigation.NavigationCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.withContext

interface NavigationEventEmitter {

    val navEvent: Flow<NavigationCommand>

    suspend fun navigate(event: NavigationCommand)

    suspend fun navigateBack()
}

class NavigationEventEmitterImpl : NavigationEventEmitter {

    private val _navEvent = Channel<NavigationCommand>(Channel.RENDEZVOUS)
    override val navEvent: Flow<NavigationCommand> = _navEvent.receiveAsFlow()

    override suspend fun navigateBack() = withContext(Dispatchers.Main.immediate) {
        _navEvent.send(NavigationCommand.Back)
    }

    override suspend fun navigate(event: NavigationCommand) = withContext(Dispatchers.Main.immediate) {
        _navEvent.send(event)
    }
}
