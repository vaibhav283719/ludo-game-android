package com.ludogame.android.core.game

import com.ludogame.android.domain.models.GameMove
import com.ludogame.android.domain.models.Player
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LudoGameEngineTest {
    private lateinit var engine: LudoGameEngine

    @Before
    fun setUp() {
        val calculator = TokenMoveCalculator()
        val rules = GameRules(calculator)
        engine = LudoGameEngine(rules)
    }

    @Test
    fun `rolling 1-5 advances turn to next player`() {
        val startIndex = engine.getState().currentPlayerIndex
        val move = GameMove(playerId = "p1", tokenId = "", steps = 3)
        engine.applyMove(move)
        val expectedIndex = (startIndex + 1) % engine.getState().players.size
        assertEquals(expectedIndex, engine.getState().currentPlayerIndex)
    }

    @Test
    fun `rolling 6 grants an extra turn (same player index)`() {
        val startIndex = engine.getState().currentPlayerIndex
        val move = GameMove(playerId = "p1", tokenId = "", steps = 6)
        engine.applyMove(move)
        assertEquals(startIndex, engine.getState().currentPlayerIndex)
    }

    @Test
    fun `invalid dice value returns failure`() {
        val move = GameMove(playerId = "p1", tokenId = "", steps = 7)
        val result = engine.applyMove(move)
        assertTrue(result.isFailure)
    }

    private fun assertTrue(condition: Boolean) = assertEquals(true, condition)
}
