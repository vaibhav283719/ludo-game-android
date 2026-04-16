package com.ludogame.android.core.utils

import timber.log.Timber

object Logger {
    fun d(message: String) = Timber.d(message)
    fun e(throwable: Throwable, message: String) = Timber.e(throwable, message)
}
