package com.ludogame.android.domain.usecases

import com.ludogame.android.domain.models.Room
import com.ludogame.android.domain.repositories.MultiplayerRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MultiplayerUseCases @Inject constructor(
    private val repository: MultiplayerRepository
) {
    fun createRoomCode(): String = repository.generateRoomCode()
    suspend fun createRoom(room: Room): Result<Unit> = repository.createRoom(room)
    suspend fun joinRoom(roomCode: String, playerId: String): Result<Unit> = repository.joinRoom(roomCode, playerId)
    fun observeRoom(roomCode: String): Flow<Room> = repository.observeRoom(roomCode)
}
