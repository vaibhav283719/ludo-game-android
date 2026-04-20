package com.ludogame.android.core.game

import javax.inject.Inject
import kotlin.random.Random

class DiceRoller @Inject constructor() {
    fun roll(): Int = Random.nextInt(1, 7)
}
