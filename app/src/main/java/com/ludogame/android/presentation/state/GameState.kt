package com.ludogame.android.presentation.state

sealed class GameState {
    data object Idle : GameState()
    data object Loading : GameState()
    data class Playing(val currentPlayerId: String) : GameState()
    data class Finished(val winnerId: String) : GameState()
    data class Error(val message: String) : GameState()
}
