package com.ludogame.android.core.game

import com.ludogame.android.core.utils.Constants
import com.ludogame.android.domain.models.Token
import javax.inject.Inject

class TokenMoveCalculator @Inject constructor() {
    fun canMove(token: Token, steps: Int): Boolean {
        if (steps !in 1..6) return false
        if (token.isFinished) return false
        if (token.position == -1) return steps == 6
        return token.position + steps <= Constants.BOARD_SIZE + Constants.HOME_PATH_LENGTH
    }

    fun nextPosition(token: Token, steps: Int): Int {
        if (!canMove(token, steps)) return token.position
        if (token.position == -1 && steps == 6) return 0
        return token.position + steps
    }
}
