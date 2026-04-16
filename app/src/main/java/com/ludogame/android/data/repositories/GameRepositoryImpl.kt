package com.ludogame.android.data.repositories

import com.ludogame.android.domain.models.Game
import com.ludogame.android.domain.models.GameMove
import com.ludogame.android.domain.repositories.GameRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor() : GameRepository {
    private var game = Game(id = "local", players = emptyList())

    override suspend fun getActiveGame(): Result<Game> = Result.success(game)

    override suspend fun applyMove(move: GameMove): Result<Game> {
        game = game.copy(diceValue = move.steps)
        return Result.success(game)
    }
}
