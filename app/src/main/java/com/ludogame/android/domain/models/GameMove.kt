package com.ludogame.android.domain.models

data class GameMove(
    val playerId: String,
    val tokenId: String,
    val steps: Int,
    val timestamp: Long = System.currentTimeMillis()
)
