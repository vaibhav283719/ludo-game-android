package com.ludogame.android.core.game

import org.junit.Assert.assertTrue
import org.junit.Test

class DiceRollerTest {
    @Test
    fun `roll returns value between 1 and 6`() {
        val roller = DiceRoller()
        repeat(1000) {
            assertTrue(roller.roll() in 1..6)
        }
    }
}
