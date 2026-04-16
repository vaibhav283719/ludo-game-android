package com.ludogame.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.ludogame.android.core.game.LudoGameEngine
import com.ludogame.android.domain.models.GameMove
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameEngine: LudoGameEngine
) : ViewModel() {
    fun playMove(move: GameMove) = gameEngine.applyMove(move)
}
