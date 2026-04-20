package com.ludogame.android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.ludogame.android.domain.usecases.MultiplayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
    private val multiplayerUseCases: MultiplayerUseCases
) : ViewModel() {
    fun createRoom() = multiplayerUseCases.createRoomCode()
}
