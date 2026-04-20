package com.ludogame.android.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> Flow<T>.collectIn(scope: CoroutineScope, collector: suspend (T) -> Unit) {
    scope.launch {
        collect { collector(it) }
    }
}
