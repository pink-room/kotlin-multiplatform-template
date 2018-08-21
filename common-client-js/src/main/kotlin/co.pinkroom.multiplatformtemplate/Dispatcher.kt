package co.pinkroom.multiplatformtemplate

import kotlinx.coroutines.experimental.*

internal actual val ApplicationDispatcher: CoroutineDispatcher = DefaultDispatcher

internal actual val UIDispatcher: CoroutineDispatcher = DefaultDispatcher