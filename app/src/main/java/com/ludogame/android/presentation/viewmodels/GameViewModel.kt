package com.ludogame.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ludogame.android.core.game.DiceRoller
import com.ludogame.android.core.game.LudoGameEngine
import com.ludogame.android.domain.models.Game
import com.ludogame.android.domain.models.GameMove
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class GameViewModel @Inject constructor(
    private val gameEngine: LudoGameEngine,
    private val diceRoller: DiceRoller
) : ViewModel() {
    private val _gameState = MutableStateFlow(gameEngine.getState())
    val gameState: StateFlow<Game> = _gameState

    private val _diceValue = MutableStateFlow(1)
    val diceValue: StateFlow<Int> = _diceValue

    fun rollDice() {
        viewModelScope.launch {
            val rolled = diceRoller.roll()
            _diceValue.value = rolled
            val currentPlayer = _gameState.value.players.getOrNull(_gameState.value.currentPlayerIndex)
            if (currentPlayer != null) {
                val move = GameMove(
                    playerId = currentPlayer.id,
                    tokenId = "",
                    steps = rolled
                )
                val result = gameEngine.applyMove(move)
                result.onSuccess { updatedGame -> _gameState.value = updatedGame }
            }
        }
    }

    fun playMove(move: GameMove) = gameEngine.applyMove(move)
}
