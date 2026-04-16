package com.ludogame.android.domain.usecases

import com.ludogame.android.domain.models.Game
import com.ludogame.android.domain.models.GameMove
import com.ludogame.android.domain.repositories.GameRepository
import javax.inject.Inject

class GameUseCases @Inject constructor(
    private val repository: GameRepository
) {
    suspend fun currentGame(): Result<Game> = repository.getActiveGame()
    suspend fun applyMove(move: GameMove): Result<Game> = repository.applyMove(move)
}
