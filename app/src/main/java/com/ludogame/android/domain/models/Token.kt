package com.ludogame.android.domain.models

data class Token(
    val id: String,
    val playerId: String,
    val position: Int = -1,
    val isFinished: Boolean = false
)
