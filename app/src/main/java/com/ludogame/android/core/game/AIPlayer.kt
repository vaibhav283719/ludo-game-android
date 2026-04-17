package com.ludogame.android.core.game

import com.ludogame.android.domain.models.Token
import javax.inject.Inject

enum class AIDifficulty {
    EASY, MEDIUM, HARD
}

class AIPlayer @Inject constructor() {
    fun chooseMove(tokens: List<Token>, diceValue: Int, difficulty: AIDifficulty): Token? {
        val movable = tokens.filter { token ->
            if (token.isFinished) false
            else if (token.position == -1) diceValue == 6
            else true
        }
        if (movable.isEmpty()) return null

        return when (difficulty) {
            AIDifficulty.EASY -> movable.random()
            AIDifficulty.MEDIUM -> movable.maxByOrNull { it.position }
            AIDifficulty.HARD -> {
                // Prioritise spreading coverage: bring home tokens onto the board before advancing,
                // but only when dice == 6 and home tokens are available.
                val homeTokens = movable.filter { it.position == -1 }
                if (homeTokens.isNotEmpty()) homeTokens.first()
                else movable.maxByOrNull { it.position }
            }
        }
    }
}
