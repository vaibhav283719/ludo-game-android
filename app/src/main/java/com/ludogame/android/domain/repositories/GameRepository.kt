package com.ludogame.android.domain.repositories

import com.ludogame.android.domain.models.Game
import com.ludogame.android.domain.models.GameMove

interface GameRepository {
    suspend fun getActiveGame(): Result<Game>
    suspend fun applyMove(move: GameMove): Result<Game>
}
