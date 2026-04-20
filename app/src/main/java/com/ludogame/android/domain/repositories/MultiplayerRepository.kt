package com.ludogame.android.domain.repositories

import com.ludogame.android.domain.models.Room
import kotlinx.coroutines.flow.Flow

interface MultiplayerRepository {
    fun generateRoomCode(): String
    suspend fun createRoom(room: Room): Result<Unit>
    suspend fun joinRoom(roomCode: String, playerId: String): Result<Unit>
    fun observeRoom(roomCode: String): Flow<Room>
}
