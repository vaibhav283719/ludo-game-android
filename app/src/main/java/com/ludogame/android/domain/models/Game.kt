package com.ludogame.android.domain.models

data class Game(
    val id: String,
    val players: List<Player>,
    val currentPlayerIndex: Int = 0,
    val diceValue: Int = 1,
    val winnerId: String? = null
)
