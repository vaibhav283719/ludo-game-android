package com.ludogame.android.domain.models

data class Player(
    val id: String,
    val name: String,
    val color: String = "red",
    val coins: Int = 0,
    val wins: Int = 0,
    val losses: Int = 0
)
