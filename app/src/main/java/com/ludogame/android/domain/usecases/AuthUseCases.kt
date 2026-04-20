package com.ludogame.android.domain.usecases

import com.ludogame.android.domain.models.Player
import com.ludogame.android.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthUseCases @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun signInGuest(): Result<Player> = repository.signInGuest()
    suspend fun signInGoogle(idToken: String): Result<Player> = repository.signInGoogle(idToken)
}
