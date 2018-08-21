package co.pinkroom.multiplatformtemplate

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI

internal actual val ApplicationDispatcher: CoroutineDispatcher = DefaultDispatcher

internal actual val UIDispatcher: CoroutineDispatcher = UI