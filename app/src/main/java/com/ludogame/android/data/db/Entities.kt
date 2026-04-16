package com.ludogame.android.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val coins: Int
)

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey val id: String,
    val currentPlayerIndex: Int,
    val winnerId: String?
)
