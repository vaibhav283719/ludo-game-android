package com.ludogame.android.presentation.state

sealed class UIEvent {
    data class ShowMessage(val message: String) : UIEvent()
    data object NavigateToLobby : UIEvent()
    data object NavigateToGame : UIEvent()
}
