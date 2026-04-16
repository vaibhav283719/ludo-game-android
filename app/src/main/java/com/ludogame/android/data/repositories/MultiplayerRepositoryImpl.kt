package com.ludogame.android.data.repositories

import com.ludogame.android.domain.models.Room
import com.ludogame.android.domain.repositories.MultiplayerRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@Singleton
class MultiplayerRepositoryImpl @Inject constructor() : MultiplayerRepository {
    private val roomState = MutableStateFlow(Room(code = "", hostId = ""))

    override fun generateRoomCode(): String {
        val chars = ('A'..'Z') + ('0'..'9')
        return (1..6).map { chars.random() }.joinToString("")
    }

    override suspend fun createRoom(room: Room): Result<Unit> {
        roomState.value = room
        return Result.success(Unit)
    }

    override suspend fun joinRoom(roomCode: String, playerId: String): Result<Unit> {
        val room = roomState.value
        if (room.code != roomCode) return Result.failure(IllegalArgumentException("Room not found"))
        roomState.value = room.copy(playerIds = room.playerIds + playerId)
        return Result.success(Unit)
    }

    override fun observeRoom(roomCode: String): Flow<Room> = roomState
}
