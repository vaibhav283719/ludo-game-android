package com.ludogame.android.core.extensions

fun String.orDash(): String = if (isBlank()) "-" else this
