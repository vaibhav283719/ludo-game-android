package com.ludogame.android.domain.models

data class Room(
    val code: String,
    val hostId: String,
    val playerIds: List<String> = emptyList(),
    val status: String = "waiting"
)
