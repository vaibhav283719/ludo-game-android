package com.ludogame.android.core.utils

object ErrorHandler {
    fun toMessage(throwable: Throwable): String = throwable.message ?: "Unknown error"
}
