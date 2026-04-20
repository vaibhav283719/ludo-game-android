package com.ludogame.android.presentation.state

data class PlayerState(
    val id: String,
    val name: String,
    val coins: Int,
    val isOnline: Boolean
)
