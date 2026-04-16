package com.ludogame.android.core.game

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
}
