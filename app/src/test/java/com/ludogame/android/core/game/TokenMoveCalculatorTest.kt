package com.ludogame.android.core.game

import com.ludogame.android.core.utils.Constants
import com.ludogame.android.domain.models.Token
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TokenMoveCalculatorTest {
    private val calculator = TokenMoveCalculator()

    @Test
    fun `token at home requires six to enter board`() {
        val token = Token(id = "1", playerId = "p1", position = -1)
        assertFalse(calculator.canMove(token, 3))
        assertTrue(calculator.canMove(token, 6))
        assertEquals(0, calculator.nextPosition(token, 6))
    }

    @Test
    fun `finished token cannot move`() {
        val token = Token(id = "2", playerId = "p1", position = 50, isFinished = true)
        assertFalse(calculator.canMove(token, 1))
    }

    @Test
    fun `token cannot overshoot home path boundary`() {
        // position 57 = last valid square (BOARD_SIZE + HOME_PATH_LENGTH - 1 = 52 + 6 - 1 = 57)
        val lastSquare = Constants.BOARD_SIZE + Constants.HOME_PATH_LENGTH - 1
        val token = Token(id = "3", playerId = "p1", position = lastSquare)
        assertFalse(calculator.canMove(token, 1))
    }

    @Test
    fun `token can move when steps stay within boundary`() {
        val token = Token(id = "4", playerId = "p1", position = 50)
        // 50 + 6 = 56 which is < 58 → allowed
        assertTrue(calculator.canMove(token, 6))
        assertEquals(56, calculator.nextPosition(token, 6))
    }
}
