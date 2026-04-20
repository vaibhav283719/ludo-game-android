package com.ludogame.android.core.game

import com.ludogame.android.domain.models.Token
import javax.inject.Inject

class GameRules @Inject constructor(
    private val tokenMoveCalculator: TokenMoveCalculator
) {
    fun isValidDice(value: Int): Boolean = value in 1..6

    fun canTokenMove(token: Token, diceValue: Int): Boolean = tokenMoveCalculator.canMove(token, diceValue)

    fun shouldGrantExtraTurn(diceValue: Int): Boolean = diceValue == 6
}
