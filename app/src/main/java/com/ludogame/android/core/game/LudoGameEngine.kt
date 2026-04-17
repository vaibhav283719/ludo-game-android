package com.ludogame.android.core.game

import com.ludogame.android.domain.models.Game
import com.ludogame.android.domain.models.GameMove
import com.ludogame.android.domain.models.Player
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LudoGameEngine @Inject constructor(
    private val rules: GameRules
) {
    private var state = Game(id = "engine", players = listOf(Player("p1", "Player 1"), Player("p2", "Player 2")))

    fun getState(): Game = state

    fun applyMove(move: GameMove): Result<Game> {
        if (!rules.isValidDice(move.steps)) {
            return Result.failure(IllegalArgumentException("Invalid dice value"))
        }
        val nextPlayerIndex = if (rules.shouldGrantExtraTurn(move.steps)) {
            state.currentPlayerIndex
        } else {
            (state.currentPlayerIndex + 1) % state.players.size
        }
        state = state.copy(
            diceValue = move.steps,
            currentPlayerIndex = nextPlayerIndex
        )
        return Result.success(state)
    }
}
